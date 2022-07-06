package pl.carrental.reservation;

import org.springframework.stereotype.Service;
import pl.carrental.car.Car;
import pl.carrental.car.CarRepository;
import pl.carrental.client.Client;
import pl.carrental.client.ClientRepository;
import pl.carrental.reservation.exceptions.CarIsAlreadyRentedException;
import pl.carrental.reservation.exceptions.RentalAlreadyFinishedException;
import pl.carrental.reservation.exceptions.RentalNotFoundException;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentalService {

    private CarRepository carRepository;
    private ClientRepository clientRepository;
    private RentalRepository rentalRepository;

    public RentalService(CarRepository carRepository, ClientRepository clientRepository, RentalRepository rentalRepository) {
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
        this.rentalRepository = rentalRepository;
    }

    List<RentalDto> findAll() {
        return rentalRepository.findAll()
                .stream().map(RentalMapper::toDto)
                .collect(Collectors.toList());
    }

    List<RentalDto> findRunningRentals() {
        return rentalRepository.findAllRunningRentals()
                .stream().map(RentalMapper::toDto)
                .collect(Collectors.toList());
    }

    RentalDto createRental(RentalDto rentalDto) {
        rentalRepository.findByCar_IdAndReturnDateIsNull(rentalDto.getCarId())
                .ifPresent(rental -> {
                    throw new CarIsAlreadyRentedException();
                });
        Optional<Client> client = clientRepository.findById(rentalDto.getClientId());
        Optional<Car> car = carRepository.findById(rentalDto.getCarId());
        Rental rental = new Rental();
        rental.setRentalDate(LocalDate.now());
        rental.setCar(car.get());
        rental.setClient(client.get());
        Rental savedRental = rentalRepository.save(rental);
        return RentalMapper.toDto(savedRental);
    }


    @Transactional
    public BigDecimal finishRental(Long id) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(RentalNotFoundException::new);
        if (rental.getReturnDate() != null) {
            throw new RentalAlreadyFinishedException();
        } else {
            rental.setReturnDate(LocalDate.now());
        }
        return countAmountToPay(id);
    }

    private BigDecimal countAmountToPay(Long id) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(RentalNotFoundException::new);
        long days = Period.between(rental.getRentalDate(), rental.getReturnDate()).getDays();
        BigDecimal pricePerDay = rental.getCar().getPricePerDay();
        return pricePerDay.multiply(BigDecimal.valueOf(days));
    }
}

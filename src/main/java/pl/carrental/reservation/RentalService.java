package pl.carrental.reservation;

import org.springframework.stereotype.Service;
import pl.carrental.car.CarRepository;
import pl.carrental.client.ClientRepository;

import java.util.List;
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

//    RentalDto createRental(RentalDto rentalDto) {
//
//    }
}

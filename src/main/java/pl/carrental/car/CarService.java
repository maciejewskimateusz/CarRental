package pl.carrental.car;

import org.hibernate.criterion.Order;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import pl.carrental.car.dto.CarDto;
import pl.carrental.car.dto.CarRentalDto;
import pl.carrental.car.exceptions.CarNotFoundException;
import pl.carrental.car.exceptions.DuplicatedRegistrationNumber;
import pl.carrental.car.mapper.CarMapper;
import pl.carrental.car.mapper.CarRentalMapper;
import pl.carrental.reservation.RentalRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private CarRepository carRepository;
    private RentalRepository rentalRepository;

    public CarService(CarRepository carRepository, RentalRepository rentalRepository) {
        this.carRepository = carRepository;
        this.rentalRepository = rentalRepository;
    }

    List<CarDto> findAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Car> pagedCars = carRepository.findAll(pageable);
        return pagedCars.stream()
                .map(CarMapper::toDto)
                .collect(Collectors.toList());
    }

    List<CarDto> findAllByCarType(CarType carType) {
        return carRepository.findAllByCarType(carType).stream()
                .map(CarMapper::toDto)
                .collect(Collectors.toList());
    }

    Optional<CarDto> findByRegistrationNo(String registrationNo) {
        return carRepository.findByRegistrationNumber(registrationNo)
                .map(CarMapper::toDto);
    }

    Optional<CarDto> findById(Long id) {
        return carRepository.findById(id).map(CarMapper::toDto);
    }

    CarDto save(CarDto carDto) {
        Optional<Car> carByRegistrationNo = carRepository.findByRegistrationNumber(carDto.getRegistrationNumber());
        carByRegistrationNo.ifPresent(car -> {
            throw new DuplicatedRegistrationNumber();
        });
        Car carEntity = CarMapper.toEntity(carDto);
        Car savedCar = carRepository.save(carEntity);
        return CarMapper.toDto(savedCar);
    }

    CarDto update(Long id, CarDto carDto) {

        carRepository.findByRegistrationNumber(carDto.getRegistrationNumber()).ifPresent(car -> {
            if (!car.getId().equals(carDto.getId())) {
                throw new DuplicatedRegistrationNumber();
            }
        });
        carDto.setId(id);
        Car carEntity = CarMapper.toEntity(carDto);
        Car savedCar = carRepository.save(carEntity);
        return CarMapper.toDto(savedCar);
    }


    List<CarRentalDto> getAllCarRentals(Long id) {
        return carRepository.findById(id)
                .map(Car::getRentals)
                .orElseThrow(CarNotFoundException::new)
                .stream().map(CarRentalMapper::toDto)
                .collect(Collectors.toList());
    }
}

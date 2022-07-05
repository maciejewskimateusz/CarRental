package pl.carrental.car;

import org.springframework.stereotype.Service;
import pl.carrental.car.dto.CarDto;
import pl.carrental.car.dto.CarRentalDto;
import pl.carrental.car.exceptions.CarNotFoundException;
import pl.carrental.car.exceptions.DuplicatedRegistrationNumber;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    List<CarDto> findAll() {
        return carRepository.findAll()
                .stream().map(CarMapper::toDto)
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

        Car car = carRepository.findById(id).orElseThrow(CarNotFoundException::new);
        carRepository.findByRegistrationNumber(carDto.getRegistrationNumber()).ifPresent(c -> {
            throw new DuplicatedRegistrationNumber();
        });
        carDto.setId(id);
        Car carEntity = CarMapper.toEntity(carDto);
        Car savedCar = carRepository.save(carEntity);
        return CarMapper.toDto(savedCar);
    }

    List<CarRentalDto> getAllCarRentals(Long id) {
        return carRepository.findById(id)
                .map(car -> car.getRentals())
                .orElseThrow(CarNotFoundException::new)
                .stream().map(CarRentalMapper::toDto)
                .collect(Collectors.toList());
    }
}

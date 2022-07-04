package pl.carrental.car;

import org.springframework.stereotype.Service;
import pl.carrental.car.dto.CarDto;
import pl.carrental.car.exceptions.DuplicatedRegistrationNumber;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    List<CarDto> findAll() {
        return repository.findAll()
                .stream().map(CarMapper::toDto)
                .collect(Collectors.toList());
    }

    CarDto save(CarDto carDto) {
        Optional<Car> carByRegistrationNo = repository.findByRegistrationNumber(carDto.getRegistrationNumber());
        carByRegistrationNo.ifPresent(car -> {
            throw new DuplicatedRegistrationNumber();
        });
        Car carEntity = CarMapper.toEntity(carDto);
        Car savedCar = repository.save(carEntity);
        return CarMapper.toDto(savedCar);
    }

    List<CarDto> findAllByCarType(CarType carType) {
        return repository.findAllByCarType(carType).stream()
                .map(CarMapper::toDto)
                .collect(Collectors.toList());
    }
//
//    List<CarDto> findAllOrderedByPrice() {
//        return repository.findAllByOrderByPricePerDayAsc().stream()
//                .map(CarMapper::toDto)
//                .collect(Collectors.toList());
//    }
}

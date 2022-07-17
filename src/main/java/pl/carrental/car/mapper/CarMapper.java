package pl.carrental.car.mapper;

import pl.carrental.car.Car;
import pl.carrental.car.dto.CarDto;

public class CarMapper {

    public static CarDto toDto(Car entity) {
        CarDto dto = new CarDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCarType(entity.getCarType());
        dto.setFuelType(entity.getFuelType());
        dto.setRegistrationNumber(entity.getRegistrationNumber());
        dto.setPricePerDay(entity.getPricePerDay());
        return dto;
    }

    public static Car toEntity(CarDto dto) {
        Car car = new Car();
        car.setId(dto.getId());
        car.setName(dto.getName());
        car.setCarType(dto.getCarType());
        car.setFuelType(dto.getFuelType());
        car.setPricePerDay(dto.getPricePerDay());
        car.setRegistrationNumber(dto.getRegistrationNumber());
        return car;
    }
}

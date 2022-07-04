package pl.carrental.car;

import pl.carrental.car.dto.CarDto;

public class CarMapper {

    static CarDto toDto(Car entity) {
        CarDto dto = new CarDto();
        dto.setId(entity.getId());
        dto.setCarType(entity.getCarType());
        dto.setFuelType(entity.getFuelType());
        dto.setRegistrationNumber(entity.getRegistrationNumber());
        dto.setMileage(entity.getMileage());
        dto.setPricePerDay(entity.getPricePerDay());
        return dto;
    }

    static Car toEntity(CarDto dto) {
        Car car = new Car();
        car.setId(dto.getId());
        car.setCarType(dto.getCarType());
        car.setFuelType(dto.getFuelType());
        car.setPricePerDay(dto.getPricePerDay());
        car.setRegistrationNumber(dto.getRegistrationNumber());
        car.setMileage(dto.getMileage());
        return car;
    }
}

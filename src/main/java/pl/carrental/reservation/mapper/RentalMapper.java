package pl.carrental.reservation.mapper;

import pl.carrental.car.Car;
import pl.carrental.client.Client;
import pl.carrental.reservation.Rental;
import pl.carrental.reservation.dto.RentalDto;

public class RentalMapper {

    public static RentalDto toDto(Rental rental) {
        RentalDto dto = new RentalDto();
        Car car = rental.getCar();
        Client client = rental.getClient();
        dto.setId(rental.getId());
        dto.setRentDate(rental.getRentalDate());
        dto.setReturnDate(rental.getReturnDate());
        dto.setCarId(car.getId());
        dto.setClientId(client.getId());
        return dto;
    }
}

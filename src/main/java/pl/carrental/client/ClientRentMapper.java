package pl.carrental.client;

import pl.carrental.car.Car;
import pl.carrental.client.dto.ClientRentDto;
import pl.carrental.reservation.Rental;

public class ClientRentMapper {

    static ClientRentDto toDto(Rental rental) {

        ClientRentDto clientRentDto = new ClientRentDto();
        Car car = rental.getCar();

        clientRentDto.setId(rental.getId());
        clientRentDto.setRentStart(rental.getRentalDate());
        clientRentDto.setRentEnd(rental.getReturnDate());
        clientRentDto.setCarId(car.getId());
        clientRentDto.setCarName(car.getName());
        clientRentDto.setCarRegistrationNumber(car.getRegistrationNumber());
        return clientRentDto;
    }
}

package pl.carrental.car.mapper;

import pl.carrental.car.dto.CarRentalDto;
import pl.carrental.client.Client;
import pl.carrental.reservation.Rental;

public class CarRentalMapper {

    public static CarRentalDto toDto(Rental rental) {

        Client rentalClient = rental.getClient();
        CarRentalDto carRentalDto = new CarRentalDto();

        carRentalDto.setId(rental.getId());
        carRentalDto.setRentalDate(rental.getRentalDate());
        carRentalDto.setReturnDane(rental.getReturnDate());
        carRentalDto.setClientId(rentalClient.getId());
        carRentalDto.setClientFirstName(rentalClient.getFirstName());
        carRentalDto.setClientLastName(rentalClient.getLastName());

        return carRentalDto;
    }
}

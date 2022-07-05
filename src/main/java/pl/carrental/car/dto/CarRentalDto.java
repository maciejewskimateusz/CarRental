package pl.carrental.car.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CarRentalDto {
    private Long id;
    private LocalDate rentalDate;
    private LocalDate returnDane;
    private Long clientId;
    private String clientFirstName;
    private String clientLastName;
    private String clientPesel;
}

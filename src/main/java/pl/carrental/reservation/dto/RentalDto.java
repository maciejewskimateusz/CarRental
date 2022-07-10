package pl.carrental.reservation.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RentalDto {

    private Long id;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private Long clientId;
    private Long carId;
}

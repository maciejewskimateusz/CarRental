package pl.carrental.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClientRentDto {

    private Long id;
    private LocalDate rentStart;
    private LocalDate rentEnd;
    private Long carId;
    private String carName;
    private String carRegistrationNumber;
}

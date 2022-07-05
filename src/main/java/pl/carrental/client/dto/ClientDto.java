package pl.carrental.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class ClientDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private String idNumber;
    private LocalDate birthDate;
}

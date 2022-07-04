package pl.carrental.client;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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

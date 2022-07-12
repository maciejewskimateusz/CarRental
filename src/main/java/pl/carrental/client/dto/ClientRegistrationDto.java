package pl.carrental.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ClientRegistrationDto {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String pesel;
    private String idNumber;
    private LocalDate birthDate;
}

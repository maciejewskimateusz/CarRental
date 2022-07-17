package pl.carrental.client.dto;

import lombok.Getter;
import lombok.Setter;
import pl.carrental.client.ClientAddress;

import java.time.LocalDate;
@Getter
@Setter
public class ClientDto {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String idNumber;
    private LocalDate birthDate;
    private ClientAddress address;
}

package pl.carrental.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class ClientCredentialsDto {

    private String email;
    private String password;
    private String role;
}

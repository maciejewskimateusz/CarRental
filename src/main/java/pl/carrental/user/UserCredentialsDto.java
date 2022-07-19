package pl.carrental.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter

public class UserCredentialsDto {

    private String email;
    private String password;
    private Set<String> roles;

    public UserCredentialsDto(String email, String password) {
        this.email = email;
        this.password = password;
        this.roles = Set.of("USER");
    }
}

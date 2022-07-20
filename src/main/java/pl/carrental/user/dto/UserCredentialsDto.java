package pl.carrental.user.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
public class UserCredentialsDto {

    private Long id;
    @Email
    @NotEmpty(message = "Email can not be empty")
    private String email;
    private String password;
    private Set<String> roles;

    public UserCredentialsDto(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = Set.of("USER");
    }
}

package pl.carrental.user.mapper;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.carrental.user.User;
import pl.carrental.user.dto.UserCredentialsDto;

@Component
@AllArgsConstructor
public class UserCredentialsDtoMapper {

    private final PasswordEncoder passwordEncoder;


    public UserCredentialsDto toDto(User user) {
        return new UserCredentialsDto(user.getId(),
                user.getEmail(),
                user.getPassword());
    }

    public User toEntity(UserCredentialsDto dto) {
        return new User(dto.getId(),
                dto.getEmail(),
                passwordEncoder.encode(dto.getPassword()),
                dto.getRoles());
    }
}

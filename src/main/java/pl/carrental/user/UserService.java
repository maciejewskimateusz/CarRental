package pl.carrental.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.carrental.user.dto.UserCredentialsDto;
import pl.carrental.user.exceptions.UserAlreadyExistException;
import pl.carrental.user.mapper.UserCredentialsDtoMapper;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;
    private final UserCredentialsDtoMapper mapper;


    public Optional<UserCredentialsDto> findByEmail(String email) {
        return repository.findByEmail(email)
                .map(mapper::toDto);
    }

    public void register(UserCredentialsDto user) {

        repository.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new UserAlreadyExistException();
                });

        User entity = mapper.toEntity(user);
        repository.save(entity);
    }
}

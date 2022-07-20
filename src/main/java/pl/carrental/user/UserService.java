package pl.carrental.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.carrental.user.dto.UserCredentialsDto;
import pl.carrental.user.exceptions.UserAlreadyExistException;
import pl.carrental.user.mapper.UserCredentialsDtoMapper;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;
    private UserCredentialsDtoMapper mapper;

    public Optional<UserCredentialsDto> findByEmail(String email) {
        return repository.findByEmail(email)
                .map(user -> mapper.toDto(user));
    }

    @Transactional
    public void register(UserCredentialsDto user) {
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistException();
        }
        User entity = mapper.toEntity(user);
        repository.save(entity);
    }
}

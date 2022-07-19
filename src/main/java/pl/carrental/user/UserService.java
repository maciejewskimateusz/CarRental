package pl.carrental.user;

import org.springframework.stereotype.Service;
import pl.carrental.user.mapper.UserCredentialsDtoMapper;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<UserCredentialsDto> findByEmail(String email) {
        return repository.findByEmail(email)
                .map(UserCredentialsDtoMapper::map);
    }
}

package pl.carrental.user.mapper;

import pl.carrental.user.User;
import pl.carrental.user.UserCredentialsDto;

public class UserCredentialsDtoMapper {

    public static UserCredentialsDto map(User user) {

        return new UserCredentialsDto(user.getEmail(), user.getPassword());
    }
}

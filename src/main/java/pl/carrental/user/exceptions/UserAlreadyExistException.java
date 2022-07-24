package pl.carrental.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Given email is already taken")
public class UserAlreadyExistException extends RuntimeException {
}

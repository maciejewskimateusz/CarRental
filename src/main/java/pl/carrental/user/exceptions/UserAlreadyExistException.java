package pl.carrental.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Użytkownik z takim adresem email juz istnieje")
public class UserAlreadyExistException extends RuntimeException {

}

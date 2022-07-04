package pl.carrental.client.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Użytkownik z takim psele już istnieje")
public class AlreadyClientExist extends RuntimeException {
}

package pl.carrental.client.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Given pesel number is already assigned to another customer")
public class ClientAlreadyExistException extends RuntimeException {
}

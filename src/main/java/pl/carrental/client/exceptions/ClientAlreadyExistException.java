package pl.carrental.client.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Podany nr pesel jest juz przypisany do innego klienta")
public class ClientAlreadyExistException extends RuntimeException {
}

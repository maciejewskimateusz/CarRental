package pl.carrental.client.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Klient musi mieć powyżej 18 lat")
public class ClientIsNotAdultException extends RuntimeException {
}

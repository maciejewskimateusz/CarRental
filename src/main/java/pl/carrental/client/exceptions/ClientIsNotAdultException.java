package pl.carrental.client.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Client must be adult")
public class ClientIsNotAdultException extends RuntimeException {
}

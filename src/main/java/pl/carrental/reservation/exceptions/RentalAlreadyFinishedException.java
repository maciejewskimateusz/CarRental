package pl.carrental.reservation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Rezerwacja już jest zakończona")
public class RentalAlreadyFinishedException extends RuntimeException {
}

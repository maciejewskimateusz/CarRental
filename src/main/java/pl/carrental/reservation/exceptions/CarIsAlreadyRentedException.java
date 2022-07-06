package pl.carrental.reservation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Samochód jest aktualnie wypożyczony")
public class CarIsAlreadyRentedException extends RuntimeException {
}

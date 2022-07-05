package pl.carrental.car.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Brak samochodu o podanym ID")
public class CarNotFoundException extends RuntimeException {
}

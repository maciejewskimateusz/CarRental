package pl.carrental.reservation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak rezerwacji o podanym ID")
public class RentalNotFoundException extends RuntimeException{
}

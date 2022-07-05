package pl.carrental.car.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Podany numer rejestracyjny jest już używany")
public class DuplicatedRegistrationNumber extends RuntimeException {
}

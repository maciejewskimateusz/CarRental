package pl.carrental.car.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Wrong car id")
public class CarNotFoundException extends RuntimeException {
}

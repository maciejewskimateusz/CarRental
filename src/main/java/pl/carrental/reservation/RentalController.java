package pl.carrental.reservation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.carrental.car.Car;

import java.util.List;

@RestController
@RequestMapping("/api/rental")
public class RentalController {

    private RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    List<RentalDto> findAll() {
        return rentalService.findAll();
    }

    @GetMapping("/active")
    List<RentalDto> findNotReturned() {
        return rentalService.findRunningRentals();
    }

}

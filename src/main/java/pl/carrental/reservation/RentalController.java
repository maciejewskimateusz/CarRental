package pl.carrental.reservation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.carrental.car.Car;

import java.net.URI;
import java.time.LocalDate;
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

    @PostMapping
    ResponseEntity<RentalDto> createRental(@RequestBody RentalDto rentalDto) {
        RentalDto savedRental = rentalService.createRental(rentalDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedRental.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedRental);
    }

    @PostMapping("/{id}/return")
    ResponseEntity returnCar(@PathVariable Long id) {
        LocalDate returnDate = rentalService.finishRental(id);
        return ResponseEntity.accepted().body(returnDate);
    }

}

package pl.carrental.car;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.carrental.car.dto.CarDto;
import pl.carrental.car.dto.CarRentalDto;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarDto> findAll(@RequestParam(defaultValue = "0", required = false) Integer pageNo,
                                @RequestParam(defaultValue = "5", required = false) Integer pageSize,
                                @RequestParam(defaultValue = "id", required = false) String sortBy,
                                @RequestParam(defaultValue = "asc", required = false) String sortDir) {
        int page = pageNo != null && pageNo >= 0 ? pageNo : 0;
        int size = pageSize != null && pageSize >= 0 ? pageSize : 0;
        return carService.findAll(page, size, sortBy, sortDir);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CarDto> findById(@PathVariable Long id) {
        return carService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/rentals")
    public List<CarRentalDto> getAllCarRentals(@PathVariable Long id) {
        return carService.getAllCarRentals(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CarDto> update(@PathVariable Long id, @RequestBody CarDto carDto) {
        if (!carDto.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Niezgodne id");
        }
        CarDto updateCar = carService.update(id, carDto);
        return ResponseEntity.ok(updateCar);
    }

    @PostMapping
    public ResponseEntity<CarDto> save(@RequestBody CarDto car) {
        CarDto savedCar = carService.save(car);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCar.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedCar);
    }
}

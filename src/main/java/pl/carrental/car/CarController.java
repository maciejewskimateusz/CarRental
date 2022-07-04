package pl.carrental.car;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.carrental.car.dto.CarDto;

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
    public List<CarDto> findAll(@RequestParam(required = false)CarType carType) {
        if (carType != null) {
            return carService.findAll();
        } else
            return carService.findAllByCarType(carType);
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

package pl.carrental.car;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByRegistrationNumber(String registrationNumber);

    List<Car> findAllByCarType(CarType carType);

    List<Car> findAllByOrderByPricePerDayAsc();
}

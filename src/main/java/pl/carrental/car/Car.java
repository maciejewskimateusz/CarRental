package pl.carrental.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.carrental.reservation.Rental;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String registrationNumber;
    private String name;
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @Enumerated(EnumType.STRING)
    private CarType carType;
    private BigDecimal pricePerDay;
    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(registrationNumber, car.registrationNumber) && Objects.equals(name, car.name) && fuelType == car.fuelType && carType == car.carType && Objects.equals(pricePerDay, car.pricePerDay) && Objects.equals(rentals, car.rentals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registrationNumber, name, fuelType, carType, pricePerDay, rentals);
    }
}

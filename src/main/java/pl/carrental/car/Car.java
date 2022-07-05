package pl.carrental.car;

import lombok.*;
import pl.carrental.reservation.Rental;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    private Integer mileage;
    private BigDecimal pricePerDay;
    @OneToMany(mappedBy = "car")
    private Set<Rental> rentals = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(registrationNumber, car.registrationNumber) && Objects.equals(name, car.name) && fuelType == car.fuelType && carType == car.carType && Objects.equals(mileage, car.mileage) && Objects.equals(pricePerDay, car.pricePerDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registrationNumber, name, fuelType, carType, mileage, pricePerDay);
    }
}

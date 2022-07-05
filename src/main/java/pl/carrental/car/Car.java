package pl.carrental.car;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
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
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @Enumerated(EnumType.STRING)
    private CarType carType;
    private Integer mileage;
    private BigDecimal pricePerDay;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(registrationNumber, car.registrationNumber) && fuelType == car.fuelType && carType == car.carType && Objects.equals(mileage, car.mileage) && Objects.equals(pricePerDay, car.pricePerDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registrationNumber, fuelType, carType, mileage, pricePerDay);
    }
}

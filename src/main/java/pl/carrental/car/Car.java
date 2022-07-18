package pl.carrental.car;

import lombok.*;
import pl.carrental.reservation.Rental;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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

}

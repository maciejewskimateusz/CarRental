package pl.carrental.reservation;

import lombok.Getter;
import lombok.Setter;
import pl.carrental.car.Car;
import pl.carrental.client.Client;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
}

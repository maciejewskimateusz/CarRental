package pl.carrental.client;

import lombok.*;
import pl.carrental.reservation.Rental;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true)
    private String pesel;
    @Past
    private LocalDate birthDate;
    private boolean premium;
    @OneToMany(mappedBy = "client")
    private List<Rental> rentals;
    @OneToOne(cascade = CascadeType.ALL)
    private ClientAddress address;

}


package pl.carrental.client;

import lombok.*;
import pl.carrental.reservation.Rental;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NotBlank(message = "Adres email jest wymagany")
    private String email;
    private String password;
    private String role;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true)
    private String idNumber;
    @Past
    private LocalDate birthDate;
    private boolean premium;
    @OneToMany(mappedBy = "client")
    private List<Rental> rentals;
    @OneToOne(cascade = CascadeType.ALL)
    private ClientAddress address;

}


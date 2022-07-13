package pl.carrental.client;

import lombok.*;
import pl.carrental.reservation.Rental;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    private String email;
    private String password;
    private String role;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false, length = 12)
    private String pesel;
    @Column(unique = true)
    private String idNumber;
    @Past
    private LocalDate birthDate;
    private boolean premium;
    @OneToMany(mappedBy = "client")
    private Set<Rental> rentals;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return premium == client.premium && Objects.equals(id, client.id) && Objects.equals(email, client.email) && Objects.equals(password, client.password) && Objects.equals(role, client.role) && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(pesel, client.pesel) && Objects.equals(idNumber, client.idNumber) && Objects.equals(birthDate, client.birthDate) && Objects.equals(rentals, client.rentals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, role, firstName, lastName, pesel, idNumber, birthDate, premium, rentals);
    }
}


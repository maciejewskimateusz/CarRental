package pl.carrental.client;

import lombok.*;
import pl.carrental.reservation.Rental;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false, length = 12)
    private String pesel;
    @Column(unique = true)
    private String idNumber;
    private LocalDate birthDate;
    @OneToMany(mappedBy = "client")
    private Set<Rental> rentals = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(pesel, client.pesel) && Objects.equals(idNumber, client.idNumber) && Objects.equals(birthDate, client.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, pesel, idNumber, birthDate);
    }
}

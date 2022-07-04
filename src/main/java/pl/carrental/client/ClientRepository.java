package pl.carrental.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByPesel(String pesel);

    List<Client> findAllByLastNameContainingIgnoreCase(String lastName);
}

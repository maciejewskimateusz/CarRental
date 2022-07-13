package pl.carrental.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RentalRepository extends JpaRepository<Rental, Long> {

    @Query("select r from Rental r where r.returnDate is null")
    List<Rental> findAllRunningRentals();

    List<Rental> findAllByClient_IdAndReturnDateIsNull(Long id);

    Optional<Rental> findByCar_IdAndReturnDateIsNull(Long id);

    Optional<Rental> findByCar_Id(Long id);
}

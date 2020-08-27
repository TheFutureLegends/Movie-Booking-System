package learn.thymeleaf.sept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import learn.thymeleaf.sept.entity.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    @Query(value = "SELECT * FROM reservation rv WHERE rv.name LIKE %:keyword%", nativeQuery = true)
    List<Reservation> findByReservationName(@Param("keyword") String keyword);
}

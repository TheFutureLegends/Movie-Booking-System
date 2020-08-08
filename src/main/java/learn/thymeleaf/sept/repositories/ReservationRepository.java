package learn.thymeleaf.sept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import learn.thymeleaf.sept.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    // CRUD Reservation DAO, no need more code for CRUD, no implementation class :)
}

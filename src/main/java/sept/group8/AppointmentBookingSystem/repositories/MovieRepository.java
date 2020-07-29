package sept.group8.AppointmentBookingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sept.group8.AppointmentBookingSystem.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    // CRUD Movie DAO, no need more code for CRUD, no implementation class :)
}

package sept.group8.AppointmentBookingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sept.group8.AppointmentBookingSystem.entity.User;


public interface UserRepository extends JpaRepository<User,Integer> {
    // CRUD User DAO, no need more code for CRUD, no implementation class :)
}

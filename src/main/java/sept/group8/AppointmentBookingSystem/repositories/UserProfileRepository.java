package sept.group8.AppointmentBookingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sept.group8.AppointmentBookingSystem.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile,Integer> {
    // CRUD User Profile DAO, no need more code for CRUD, no implementation class :)
}

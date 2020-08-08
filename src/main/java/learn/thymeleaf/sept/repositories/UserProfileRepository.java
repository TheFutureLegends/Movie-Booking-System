package learn.thymeleaf.sept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import learn.thymeleaf.sept.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile,Integer> {
    // CRUD User Profile DAO, no need more code for CRUD, no implementation class :)
}

package learn.thymeleaf.sept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import learn.thymeleaf.sept.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    // CRUD User DAO, no need more code for CRUD, no implementation class :)
}

package learn.thymeleaf.sept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import learn.thymeleaf.sept.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM user u WHERE u.user_name LIKE %:keyword%", nativeQuery = true)
    List<User> findByUserName(String keyword);
    // CRUD User DAO, no need more code for CRUD, no implementation class :)
}

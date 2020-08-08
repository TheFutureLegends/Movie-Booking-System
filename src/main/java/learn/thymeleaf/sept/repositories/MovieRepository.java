package learn.thymeleaf.sept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import learn.thymeleaf.sept.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    // CRUD Movie DAO, no need more code for CRUD, no implementation class :)
}

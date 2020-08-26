package learn.thymeleaf.sept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import learn.thymeleaf.sept.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    @Query(value = "SELECT * FROM movie mv WHERE mv.movie_name LIKE %:keyword%", nativeQuery = true)
    List<Movie> findByMovieName(@Param("keyword") String keyword);

}

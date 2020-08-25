package learn.thymeleaf.sept.serviceInterface;

import learn.thymeleaf.sept.entity.Movie;
import learn.thymeleaf.sept.entity.User;

import java.util.List;

public interface MovieServiceInterface {
    public List<Movie> findAll();
    public Movie findById(int id);
    public void create(Movie movie);
    public void deleteById(int id);
}

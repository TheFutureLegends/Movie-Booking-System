package learn.thymeleaf.sept.serviceInterface;

import learn.thymeleaf.sept.entity.Movie;
import learn.thymeleaf.sept.entity.User;

import java.util.List;

public interface MovieServiceInterface {
    public List<Movie> findAll();
    public Movie findById(int id);
    public void create(Movie movie);
    public void deleteById(int id);
    public List<Movie> findByMovieName(String movieNameKeyword);
    public List<Movie> findByCategory(String categoryKeyword);
    public List<Movie> findByRated(Integer ratedKeyword);
    public List<Movie> findByMovieNameCategory(String movieNameKeyword, String categoryKeyword);
    public List<Movie> findByMovieNAmeRated(String movieNameKeyword, Integer ratedKeyword);
    public List<Movie> findByCategoryRated(String categoryKeyword, Integer ratedKeyword);
    public List<Movie> findByMovieNameCategoryRated(String movieNameKeyword, String categoryKeyword, Integer ratedKeyword);
}

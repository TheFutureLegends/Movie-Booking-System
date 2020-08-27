package learn.thymeleaf.sept.service;

import learn.thymeleaf.sept.entity.Movie;
import learn.thymeleaf.sept.repositories.MovieRepository;
import learn.thymeleaf.sept.serviceInterface.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements MovieServiceInterface {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository theMovieRepository) {
        movieRepository = theMovieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(int id) {
        Optional<Movie> result = movieRepository.findById(id);

        Movie movie = null;

        if (result.isPresent()) {
            movie = result.get();
        }
        else {
            // we didn't find the movie
            throw new RuntimeException("Did not find movie id - " + id);
        }

        return movie;
    }

    @Override
    public void create(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void deleteById(int id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> findByMovieName(String keyword) {
        return movieRepository.findByMovieName(keyword);
    }
}

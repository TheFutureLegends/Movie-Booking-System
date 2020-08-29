package learn.thymeleaf.sept.service;

import learn.thymeleaf.sept.entity.Movie;
import learn.thymeleaf.sept.entity.User;
import learn.thymeleaf.sept.repositories.MovieRepository;
import learn.thymeleaf.sept.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class MovieServiceTest {
    @MockBean
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @Test
    void findAll() {
        // declare 2 fake ids
        int id = 1;
        int id2 = 2;
        // create mock user profile 1
        Movie mockMovie1 = new Movie();
        mockMovie1.setId(id);
        mockMovie1.setMovieName("shit");
        // create mock user profile 2
        Movie mockMovie2 = new Movie();
        mockMovie2.setId(id2);
        mockMovie2.setMovieName("Shitty Name 2");
        // create mock user profile list
        List<Movie> mockMovieList = new ArrayList<>();
        mockMovieList.add(mockMovie1);
        mockMovieList.add(mockMovie2);
        when(movieRepository.findAll()).thenReturn(mockMovieList);
        // use service to test the list
        MovieService service = new MovieService(movieRepository);
        List<Movie> result = service.findAll();
        assertEquals(2, result.size());
    }

    @Test
    void findById() {
        // create fake user profile with id 1
        int id = 1;
        Movie mockMovieProfile = new Movie();
        mockMovieProfile.setId(id);
        mockMovieProfile.setMovieName("Shitty Name");
        Mockito.when(movieRepository.findById(id)).thenReturn(Optional.of(mockMovieProfile));
        MovieService service = new MovieService(movieRepository);
        // use service to find the fake user profile
        Movie result = service.findById(1);
        assertEquals(mockMovieProfile, result);
    }

    @Test
    void create() {
        /*MovieService service = new MovieService(movieRepository);
        Movie fake = new Movie();
        fake.setId(1);
        fake.setMovieName("Fake name");
        int initialSize = service.findAll().size();
        service.create(fake);
        int finalSize = service.findAll().size();
        assertEquals(1, finalSize- initialSize);*/
    }

    @Test
    void deleteById() {
        int id = 1;
        Movie mockMovieProfile = new Movie();
        mockMovieProfile.setId(id);
        mockMovieProfile.setMovieName("Shitty Name");
        MovieService service = new MovieService(movieRepository);
        // delete user profile's id = 1
        service.deleteById(1);
        assertThrows(RuntimeException.class, () -> service.findById(1));
    }

    @Test
    void findByName() {
        int id = 1;
        Movie mockMovie = new Movie();
        mockMovie.setId(id);
        mockMovie.setMovieName("Shitty Name");
        List<Movie> mockMovieList = new ArrayList<>();
        mockMovieList.add(mockMovie);
        when(movieRepository.findByMovieName("Shitty Name")).thenReturn(mockMovieList);
        MovieService service = new MovieService(movieRepository);
        List<Movie> result = service.findByMovieName("Shitty Name");
        assertEquals(result, mockMovieList);
    }
}
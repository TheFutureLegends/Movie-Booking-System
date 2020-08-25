package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.Movie;
import learn.thymeleaf.sept.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/movie")
    public String menu(Model model){
        List<Movie> movies = movieService.findAll();
        Model theModel = model.addAttribute("movies", movies);
        return "movie";
    }

    @RequestMapping("/movie/login")
    public String login(){
        return "movie-log-in";
    }
}

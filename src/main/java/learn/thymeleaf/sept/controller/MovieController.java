package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.Movie;
import learn.thymeleaf.sept.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/movie")
    public String menu(Model model, String keyword){
        List<Movie> movies = movieService.findAll();
        if (keyword != null) {
            Model theModel = model.addAttribute("movies", movieService.findByMovieName(keyword));
        } else {
            Model theModel = model.addAttribute("movies", movies);
        }
        return "movie";
    }

    @RequestMapping("/movieLogin")
    public String menuLogin(Model model, String keyword){
        List<Movie> movies = movieService.findAll();
        if (keyword != null) {
            Model theModel = model.addAttribute("movies", movieService.findByMovieName(keyword));
        } else {
            Model theModel = model.addAttribute("movies", movies);
        }
        return "movie-log-in";
    }

    @RequestMapping("/movieAdmin")
    public String menuAdmin(Model model, String keyword){
        List<Movie> movies = movieService.findAll();
        if (keyword != null) {
            Model theModel = model.addAttribute("movies", movieService.findByMovieName(keyword));
        } else {
            Model theModel = model.addAttribute("movies", movies);
        }
        return "admin/movie-log-in";
    }

    @RequestMapping("/movie/login")
    public String login(Model model){
        List<Movie> movies = movieService.findAll();
        Model theModel = model.addAttribute("movies", movies);
        return "movie-log-in";
    }

    @RequestMapping("/movie/admin")
    public String adminLogin(Model model){
        List<Movie> movies = movieService.findAll();
        Model theModel = model.addAttribute("movies", movies);
        return "admin/movie-log-in";
    }

}

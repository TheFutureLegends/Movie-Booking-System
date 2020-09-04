package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.Movie;
import learn.thymeleaf.sept.entity.User;
import learn.thymeleaf.sept.service.MovieService;
import learn.thymeleaf.sept.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;
    private final UserService userService;

    public MovieController(MovieService movieService, UserService userService) {
        this.movieService = movieService;
        this.userService = userService;
    }


    // Search function for guests
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

    // Serach function for membership
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

    // Search function for admin
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

    // listing movies as membership
    @RequestMapping("/movie/login")
    public String login(Model model){
        List<Movie> movies = movieService.findAll();
        Model theModel = model.addAttribute("movies", movies);
        return "movie-log-in";
    }

    // listing movies as admin
    @RequestMapping("/movie/admin")
    public String adminLogin(@RequestParam("userId")int theId, Model movieModel, Model userModel){
        List<Movie> movies = movieService.findAll();
        User user = userService.findById(theId);
        Model theMovieModel = movieModel.addAttribute("movies", movies);
        Model theUserModel = userModel.addAttribute("user", user);
        return "admin/movie-log-in";
    }

}

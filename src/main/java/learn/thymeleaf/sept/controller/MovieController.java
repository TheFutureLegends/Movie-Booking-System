package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.Movie;
import learn.thymeleaf.sept.entity.User;
import learn.thymeleaf.sept.service.MovieService;
import learn.thymeleaf.sept.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String menu(Model model, String movieNameKeyword, String categoryKeyword, Integer ratedKeyword, Model userModel){

        userModel.addAttribute("user", new User());

        if (ratedKeyword == null) {
            ratedKeyword = 0;
        } else {
            ratedKeyword.intValue();
        }
        List<Movie> movies = movieService.findAll();
        if (movieNameKeyword != null && categoryKeyword != null && ratedKeyword != 0) {
            Model theModel = model.addAttribute("movies", movieService.findByMovieNameCategoryRated(movieNameKeyword, categoryKeyword, ratedKeyword));
        } else if (movieNameKeyword != null && categoryKeyword != null && ratedKeyword == 0) {
            Model theModel = model.addAttribute("movies", movieService.findByMovieNameCategory(movieNameKeyword, categoryKeyword));
        } else if (movieNameKeyword != null && categoryKeyword == null && ratedKeyword != 0) {
            Model theModel = model.addAttribute("movies", movieService.findByMovieNAmeRated(movieNameKeyword, ratedKeyword));
        } else if (movieNameKeyword == null && categoryKeyword != null && ratedKeyword != 0) {
            Model theModel = model.addAttribute("movies", movieService.findByCategoryRated(categoryKeyword, ratedKeyword));
        } else if (movieNameKeyword != null) {
            Model theModel = model.addAttribute("movies", movieService.findByMovieName(movieNameKeyword));
        } else if (categoryKeyword != null) {
            Model theModel = model.addAttribute("movies", movieService.findByCategory(categoryKeyword));
        } else if (ratedKeyword != 0) {
            Model theModel = model.addAttribute("movies", movieService.findByRated(ratedKeyword));
        } else {
            Model theModel = model.addAttribute("movies", movies);
        }
        return "movie";
    }

    // Search function for membership
    @RequestMapping("/movieLogin")
    public String menuLogin(Model model, String movieNameKeyword, String categoryKeyword, Integer ratedKeyword){
        if (ratedKeyword == null) {
            ratedKeyword = 0;
        } else {
            ratedKeyword.intValue();
        }
        List<Movie> movies = movieService.findAll();
        if (movieNameKeyword != null && categoryKeyword != null && ratedKeyword != 0) {
            Model theModel = model.addAttribute("movies", movieService.findByMovieNameCategoryRated(movieNameKeyword, categoryKeyword, ratedKeyword));
        } else if (movieNameKeyword != null && categoryKeyword != null && ratedKeyword == 0) {
            Model theModel = model.addAttribute("movies", movieService.findByMovieNameCategory(movieNameKeyword, categoryKeyword));
        } else if (movieNameKeyword != null && categoryKeyword == null && ratedKeyword != 0) {
            Model theModel = model.addAttribute("movies", movieService.findByMovieNAmeRated(movieNameKeyword, ratedKeyword));
        } else if (movieNameKeyword == null && categoryKeyword != null && ratedKeyword != 0) {
            Model theModel = model.addAttribute("movies", movieService.findByCategoryRated(categoryKeyword, ratedKeyword));
        } else if (movieNameKeyword != null) {
            Model theModel = model.addAttribute("movies", movieService.findByMovieName(movieNameKeyword));
        } else if (categoryKeyword != null) {
            Model theModel = model.addAttribute("movies", movieService.findByCategory(categoryKeyword));
        } else if (ratedKeyword != 0) {
            Model theModel = model.addAttribute("movies", movieService.findByRated(ratedKeyword));
        } else {
            Model theModel = model.addAttribute("movies", movies);
        }
        return "movie-log-in";
    }

    // Search function for admin
    @RequestMapping("/movieAdmin")
    public String menuAdmin(Model model, String movieNameKeyword, String categoryKeyword, Integer ratedKeyword){
        if (ratedKeyword == null) {
            ratedKeyword = 0;
        } else {
            ratedKeyword.intValue();
        }
        List<Movie> movies = movieService.findAll();
        if (movieNameKeyword != null && categoryKeyword != null && ratedKeyword != 0) {
            Model theModel = model.addAttribute("movies", movieService.findByMovieNameCategoryRated(movieNameKeyword, categoryKeyword, ratedKeyword));
        } else if (movieNameKeyword != null && categoryKeyword != null && ratedKeyword == 0) {
            Model theModel = model.addAttribute("movies", movieService.findByMovieNameCategory(movieNameKeyword, categoryKeyword));
        } else if (movieNameKeyword != null && categoryKeyword == null && ratedKeyword != 0) {
            Model theModel = model.addAttribute("movies", movieService.findByMovieNAmeRated(movieNameKeyword, ratedKeyword));
        } else if (movieNameKeyword == null && categoryKeyword != null && ratedKeyword != 0) {
            Model theModel = model.addAttribute("movies", movieService.findByCategoryRated(categoryKeyword, ratedKeyword));
        } else if (movieNameKeyword != null) {
            Model theModel = model.addAttribute("movies", movieService.findByMovieName(movieNameKeyword));
        } else if (categoryKeyword != null) {
            Model theModel = model.addAttribute("movies", movieService.findByCategory(categoryKeyword));
        } else if (ratedKeyword != 0) {
            Model theModel = model.addAttribute("movies", movieService.findByRated(ratedKeyword));
        } else {
            Model theModel = model.addAttribute("movies", movies);
        }
        return "admin/movie-log-in";
    }


    // listing movies as membership
    @RequestMapping("/movie/login")
    public String login(@RequestParam("userId")int theId,Model userModel,Model movieModel){
        List<Movie> movies = movieService.findAll();
        User user = userService.findById(theId);
        Model theMovieModel = movieModel.addAttribute("movies", movies);
        Model theUserModel = userModel.addAttribute("user", user);
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

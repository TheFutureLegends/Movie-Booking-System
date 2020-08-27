package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.Movie;
import learn.thymeleaf.sept.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping ("/admin/movie")
public class AdminMovieController {
    private final MovieService movieService;

    public AdminMovieController(MovieService theMovieService) {
        movieService = theMovieService;
    }

    // add mapping for "/list"

    @GetMapping("/listMovies")
    public String listMovies(Model theModel, String keyword) {

        // get movies from db
        List<Movie> theMovies = movieService.findAll();
        // check if there is a search keyword
        if(keyword != null){
            theModel.addAttribute("movies",MovieService.findByMovieName(keyword));
        }
        else {
            // add to the spring model
            theModel.addAttribute("movies", theMovies);
        }

        return "admin/movie/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Movie theMovie = new Movie();

        theModel.addAttribute("movie", theMovie);

        return "admin/movie/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("movieId")int theId, Model theModel){
        //get the employee from service
        Movie movie = movieService.findById(theId);
        //set the employee as a model attribute to pre-populate the form
        theModel.addAttribute("movie", movie);
        // send over to our form
        return "admin/movie/create-update-form";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") Movie theMovie) {

        // save the employee
        movieService.create(theMovie);

        // use a redirect to prevent duplicate submissions
        return "redirect:admin/movie/listMovies";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("movieId")int theId){
        //get the employee
        movieService.deleteById(theId);
        //redirect to list
        return "redirect:admin/movie/listMovies";
    }
}

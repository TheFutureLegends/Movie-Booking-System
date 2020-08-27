package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.Movie;
import learn.thymeleaf.sept.entity.Reservation;
import learn.thymeleaf.sept.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/reservation")
public class AdminReservationController {

    private final ReservationService reservationService;

    public AdminMovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/list")
    public String listMovies(Model theModel, String keyword) {

        // get employees from db
        List<Movie> movies = movieService.findAll();
        // check if there is a search keyword
        if(keyword != null){
            theModel.addAttribute("movies", movieService.findByMovieName(keyword));
        }
        else {
            // add to the spring model
            theModel.addAttribute("movies", movies);
        }

        return "admin/movie/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("movieId")int theId, Model theModel){
        //get the employee from service
        Movie movie = movieService.findById(theId);
        //set the employee as a model attribute to pre-populate the form
        theModel.addAttribute("movie", movie);
        // send over to our form
        return "admin/movie/add-update-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("movieId")int theId){
        //get the employee
        movieService.deleteById(theId);
        //redirect to list
        return "redirect:/admin/movie/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Movie movie = new Movie();

        theModel.addAttribute("movie", movie);

        return "admin/movie/add-update-form";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {

        // save the employee
        movieService.create(movie);

        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/movie/list";
    }
}

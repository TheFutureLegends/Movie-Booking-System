package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.Movie;
import learn.thymeleaf.sept.entity.Reservation;
import learn.thymeleaf.sept.entity.User;
import learn.thymeleaf.sept.service.MovieService;
import learn.thymeleaf.sept.service.ReservationService;
import learn.thymeleaf.sept.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    private final MovieService movieService;
    private final UserService userService;
    private final ReservationService reservationService;

    public PaymentController(MovieService movieService, UserService userService, ReservationService reservationService) {
        this.movieService = movieService;
        this.userService = userService;
        this.reservationService = reservationService;
    }

    @RequestMapping("/payment")
    public String menu(@RequestParam("userId")int userId, Model userModel, @RequestParam("movieId")int movieId, Model movieModel){

        Movie movie = movieService.findById(movieId);
        User user = userService.findById(userId);
        Model theMovieModel = movieModel.addAttribute("movie", movie);
        Model theUserModel = userModel.addAttribute("user", user);

        return "payment";
    }

    @RequestMapping("/save")
    public String saveReservation(@RequestParam("userId")int userId, Model userModel, Model theModel, @RequestParam("movieName")String movieName, HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        List<Movie> movie = movieService.findByMovieName(movieName);
        User user = userService.findById(userId);
        Model theUserModel = userModel.addAttribute("user", user);

        Reservation reservation = new Reservation(movie.get(0).getMovieName(), movie.get(0).getMovieStartTime(), "Good");

        // save the employee
        reservationService.create(reservation);

        // get employees from db
        List<Reservation> reservations = reservationService.findAll();

        theModel.addAttribute("reservations", reservations);

        out.println("<script>alert('Reservation successful. Thank you for using our service.');</script>");
        out.flush();

        return "history";
    }

    @RequestMapping("/creditCard")
    public String creditCardReservation(Integer userId, Model userModel, Model theModel, String movieName, HttpServletResponse response, String userNameKeyword, String cardNumberKeyword, Integer monthKeyword, Integer yearKeyword, String cvvKeyword) throws IOException {

        if (monthKeyword == null) {
            monthKeyword = 0;
        } else {
            monthKeyword.intValue();
        }
        if (yearKeyword == null) {
            yearKeyword = 0;
        } else {
            yearKeyword.intValue();
        }
        if (userId == null) {
            userId = 0;
        } else {
            userId.intValue();
        }

        User user = userService.findById(userId);
        Model theUserModel = userModel.addAttribute("user", user);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (userNameKeyword != null && cardNumberKeyword != null && monthKeyword != 0 && yearKeyword != 0 && cvvKeyword != null) {
            List<Movie> movie = movieService.findByMovieName(movieName);

            Reservation reservation = new Reservation(movie.get(0).getMovieName(), movie.get(0).getMovieStartTime(), "Good");

            // save the employee
            reservationService.create(reservation);

            // get employees from db
            List<Reservation> reservations = reservationService.findAll();

            theModel.addAttribute("reservations", reservations);

            out.println("<script>alert('Reservation successful. Thank you for using our service.');</script>");
            out.flush();

            return "history";
        } else {
            out.println("<script>alert('Reservation failed. Please check payment information');</script>");
            out.flush();

            return "homepage-log-in";
        }
    }
}

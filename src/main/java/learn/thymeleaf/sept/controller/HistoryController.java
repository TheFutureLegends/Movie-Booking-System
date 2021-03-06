package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.Reservation;
import learn.thymeleaf.sept.entity.User;
import learn.thymeleaf.sept.service.ReservationService;
import learn.thymeleaf.sept.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryController {

    private final UserService userService;
    private final ReservationService reservationService;

    public HistoryController(UserService userService, ReservationService reservationService) {
        this.userService = userService;
        this.reservationService = reservationService;
    }

    @RequestMapping("/login")
    public String login(@RequestParam("userId")int theId, Model userModel, Model theModel, String keyword){
        User user = userService.findById(theId);
        Model theUserModel = userModel.addAttribute("user", user);

        // get employees from db
        List<Reservation> reservations = reservationService.findAll();
        // check if there is a search keyword
        if(keyword != null){
            theModel.addAttribute("reservations", reservationService.findByReservationName(keyword));
        }
        else {
            // add to the spring model
            theModel.addAttribute("reservations", reservations);
        }

        return "history";
    }

    @RequestMapping("/loginSearch")
    public String loginSearch(Integer userId, Model userModel, Model theModel, String keyword){
        if (userId == null) {
            userId = 0;
        } else {
            userId.intValue();
        }

        User user = userService.findById(userId);
        Model theUserModel = userModel.addAttribute("user", user);

        // get employees from db
        List<Reservation> reservations = reservationService.findAll();
        // check if there is a search keyword
        if(keyword != null){
            theModel.addAttribute("reservations", reservationService.findByReservationName(keyword));
        }
        else {
            // add to the spring model
            theModel.addAttribute("reservations", reservations);
        }

        return "history";
    }


    @RequestMapping("/admin")
    public String adminLogin(@RequestParam("userId")int theId, Model userModel, Model theModel, String keyword){
        User user = userService.findById(theId);
        Model theUserModel = userModel.addAttribute("user", user);

        // get employees from db
        List<Reservation> reservations = reservationService.findAll();
        // check if there is a search keyword
        if(keyword != null){
            theModel.addAttribute("reservations", reservationService.findByReservationName(keyword));
        }
        else {
            // add to the spring model
            theModel.addAttribute("reservations", reservations);
        }

        return "admin/history";
    }

    @RequestMapping("/adminSearch")
    public String adminLoginSearch(Integer userId, Model userModel, Model theModel, String keyword){
        if (userId == null) {
            userId = 0;
        } else {
            userId.intValue();
        }

        User user = userService.findById(userId);
        Model theUserModel = userModel.addAttribute("user", user);

        // get employees from db
        List<Reservation> reservations = reservationService.findAll();
        // check if there is a search keyword
        if(keyword != null){
            theModel.addAttribute("reservations", reservationService.findByReservationName(keyword));
        }
        else {
            // add to the spring model
            theModel.addAttribute("reservations", reservations);
        }

        return "admin/history";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("reservationId")int theId, @RequestParam("userId")int userId, Model userModel){
        User user = userService.findById(userId);
        Model theUserModel = userModel.addAttribute("user", user);

        //get the employee
        reservationService.deleteById(theId);

        return "homepage-log-in";
    }

    @GetMapping("/deleteAdmin")
    public String deleteAdmin(@RequestParam("reservationId")int theId, @RequestParam("userId")int userId, Model userModel){
        User user = userService.findById(userId);
        Model theUserModel = userModel.addAttribute("user", user);

        //get the employee
        reservationService.deleteById(theId);

        return "admin/homepage-log-in";
    }

}

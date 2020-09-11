package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.Reservation;
import learn.thymeleaf.sept.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/reservation")
public class AdminReservationController {

    private final ReservationService reservationService;

    public AdminReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/list")
    public String listReservations(Model theModel, String keyword) {

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

        return "admin/reservation/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("reservationId")int theId, Model theModel){
        //get the employee from service
        Reservation reservation = reservationService.findById(theId);
        //set the employee as a model attribute to pre-populate the form
        theModel.addAttribute("reservation", reservation);
        // send over to our form
        return "admin/reservation/add-update-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("reservationId")int theId){
        //get the employee
        reservationService.deleteById(theId);
        //redirect to list
        return "redirect:/admin/reservation/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Reservation reservation = new Reservation();

        theModel.addAttribute("reservation", reservation);

        return "admin/reservation/add-update-form";
    }

    @PostMapping("/save")
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation) {

        // save the employee
        reservationService.create(reservation);

        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/reservation/list";
    }
}
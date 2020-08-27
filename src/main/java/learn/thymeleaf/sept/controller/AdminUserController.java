package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.User;
import learn.thymeleaf.sept.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listUser(Model theModel, String keyword) {

        // get user from db
        List<User> users = userService.findAll();
        // check if there is a search keyword
        if(keyword != null){
            theModel.addAttribute("users", userService.findByUserName(keyword));
        }
        else {
            // add to the spring model
            theModel.addAttribute("users", users);
        }

        return "admin/user/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId")int theId, Model theModel){
        //get the user from service
        User user = userService.findById(theId);
        //set the user as a model attribute to pre-populate the form
        theModel.addAttribute("user", user);
        // send over to our form
        return "admin/user/add-update-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId")int theId){
        //get the employee
        userService.deleteById(theId);
        //redirect to list
        return "redirect:/admin/user/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        User user = new User();

        theModel.addAttribute("user", user);

        return "admin/user/add-update-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {

        // save the user
        userService.create(user);

        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/user/list";
    }
}

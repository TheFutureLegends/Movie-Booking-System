package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.User;
import learn.thymeleaf.sept.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/index")
    public String home(Model theModel){
        theModel.addAttribute("user", new User());
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "homepage-log-in";
    }

    @RequestMapping("/admin")
    public String adminLogin(){
        return "admin/homepage-log-in";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {

        // save the user
        userService.create(user);

        // use a redirect to prevent duplicate submissions
        return "redirect:/home/index";
    }
}

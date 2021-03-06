package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.User;
import learn.thymeleaf.sept.entity.UserProfile;
import learn.thymeleaf.sept.service.UserProfileService;
import learn.thymeleaf.sept.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final UserProfileService userProfileService;
    private final UserService userService;
    public HomeController(UserProfileService userProfileService, UserService userService) {
        this.userProfileService = userProfileService;
        this.userService = userService;

    }

    @RequestMapping("/index")
    public String home(Model theModel, Model userProfileModel){
        theModel.addAttribute("user", new User());
        userProfileModel.addAttribute("userProfile", new UserProfile());
        return "index";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("userId")int theId,Model userModel){
        User user = userService.findById(theId);
        Model theUserModel = userModel.addAttribute("user", user);
        return "homepage-log-in";

    }

    @RequestMapping("/admin")
    public String adminLogin(@RequestParam("userId")int theId, Model userModel){
        User user = userService.findById(theId);
        Model theUserModel = userModel.addAttribute("user", user);
        return "admin/homepage-log-in";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, @ModelAttribute("userProfile") UserProfile userProfile, HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        // save the user
        userService.create(user);
        userProfileService.create(userProfile);

        out.println("<script>alert('Registration successful'); location.href='/home/index';</script>");
        out.flush();

        return "redirect:/home/index";
    }
}

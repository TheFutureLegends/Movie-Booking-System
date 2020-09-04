package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.User;
import learn.thymeleaf.sept.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TheatersController {
    private final UserService userService;

    public TheatersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/theater")
    public String menu(){
        return "theater";
    }

    @RequestMapping("/theater/login")
    public String login(@RequestParam("userId")int theId,Model userModel){
            User user = userService.findById(theId);
            Model theUserModel = userModel.addAttribute("user", user);

        return "theater-log-in";
    }


    @RequestMapping("/theater/admin")
    public String adminLogin(@RequestParam("userId")int theId, Model userModel){
        User user = userService.findById(theId);
        Model theUserModel = userModel.addAttribute("user", user);
        return "admin/theater-log-in";
    }
}

package learn.thymeleaf.sept.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
    @RequestMapping("/profile/login")
    public String menu(){
        return "profile-log-in";
    }
    @RequestMapping("/profile/login/edit")
    public String edit(){
        return "profile-edit";
    }
}

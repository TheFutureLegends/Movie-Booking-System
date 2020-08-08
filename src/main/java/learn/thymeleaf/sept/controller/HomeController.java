package learn.thymeleaf.sept.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(){
        return "index";
    }

    @RequestMapping("/home/login")
    public String login(){
        return "homepage-log-in";
    }
}

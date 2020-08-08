package learn.thymeleaf.sept.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TheatersController {
    @RequestMapping("/theater")
    public String menu(){
        return "theater";
    }

    @RequestMapping("/theater/login")
    public String login(){
        return "theater-log-in";
    }
}

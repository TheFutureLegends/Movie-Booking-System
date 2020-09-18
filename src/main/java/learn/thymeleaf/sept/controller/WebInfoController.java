package learn.thymeleaf.sept.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebInfoController {
    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    @RequestMapping("/about/login")
    public String login(){
        return "about-log-in";
    }
}

package learn.thymeleaf.sept.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {
    @RequestMapping("/movie")
    public String menu(){
        return "movie";
    }

    @RequestMapping("/movie/login")
    public String login(){
        return "movie-log-in";
    }
}

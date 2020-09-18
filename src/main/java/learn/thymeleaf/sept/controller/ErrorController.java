package learn.thymeleaf.sept.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import learn.thymeleaf.sept.entity.User;
import learn.thymeleaf.sept.service.UserService;

@Controller
@RequestMapping("/error")
public class ErrorController {
    private final UserService userService;
    
    public ErrorController(UserService userService){
    this.userService = userService;
}

    @RequestMapping("/errorPage")
    public String error(@RequestParam("userId")int theId, Model userModel){
        User user = userService.findById(theId);
    
        Model theUserModel = userModel.addAttribute("user", user);
    

        return "/error";
    }
}



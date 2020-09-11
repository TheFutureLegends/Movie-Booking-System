package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.User;
import learn.thymeleaf.sept.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {
    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/profile/login")
    public String menu(@RequestParam("userId")int theId, Model userModel){
        User user = userService.findById(theId);
        Model theUserModel = userModel.addAttribute("user", user);
        return "profile-log-in";
    }

    @RequestMapping("/profile/admin")
    public String admin(@RequestParam("userId")int theId, Model userModel){
        User user = userService.findById(theId);
        Model theUserModel = userModel.addAttribute("user", user);
        return "admin/profile-log-in";
    }
    @RequestMapping("/profile/login/edit")
    public String edit(){
        return "profile-edit";
    }

    @RequestMapping("/profile/admin/edit")
    public String editAdmin(@RequestParam("userId")int theId, Model userModel, Model userProfileModel){
        User user = userService.findById(theId);
        Model theUserModel = userModel.addAttribute("user", user);
        Model theUserProfileModel = userProfileModel.addAttribute("userProfile", user);
        return "admin/profile-edit";
    }

}

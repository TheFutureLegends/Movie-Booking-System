package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.User;
import learn.thymeleaf.sept.entity.UserProfile;
import learn.thymeleaf.sept.service.UserProfileService;
import learn.thymeleaf.sept.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final UserService userService;
    private final UserProfileService userProfileService;

    public ProfileController(UserService userService, UserProfileService userProfileService) {
        this.userService = userService;
        this.userProfileService = userProfileService;
    }
    @RequestMapping("/login")
    public String menu(@RequestParam("userId")int theId, Model userModel,Model userProfileModel ){
        User user = userService.findById(theId);
        UserProfile userProfile = userProfileService.findById(theId);
        Model theUserModel = userModel.addAttribute("user", user);
        Model theUserProfileModel = userProfileModel.addAttribute("userProfile",userProfile);
        return "profile-log-in";
    }

    @RequestMapping("/admin")
    public String admin(@RequestParam("userId")int theId, Model userModel, Model userProfileModel){
        User user = userService.findById(theId);
        UserProfile userProfile = userProfileService.findById(theId);
        Model theUserModel = userModel.addAttribute("user", user);
        Model theUserProfileModel = userProfileModel.addAttribute("userProfile",userProfile);

        return "admin/profile-log-in";
    }
    @GetMapping("/edit")
    public String editUser(@RequestParam("userProfileId")int theId, Model theModel, Model userModel){
        User user = userService.findById(theId);
        Model theUserModel = userModel.addAttribute("user", user);
        //get the user from service
        UserProfile userProfile = userProfileService.findById(theId);
        //set the user as a model attribute to pre-populate the form
        theModel.addAttribute("userProfile", userProfile);
        // send over to our form
        return "/profile-edit";
    }


    @GetMapping("/admin/edit")
    public String editAdmin(@RequestParam("userProfileId")int theId, Model theModel, Model userModel){
        User user = userService.findById(theId);
        Model theUserModel = userModel.addAttribute("user", user);
        //get the user from service
        UserProfile userProfile = userProfileService.findById(theId);
        //set the user as a model attribute to pre-populate the form
        theModel.addAttribute("userProfile", userProfile);
        // send over to our form
        return "admin/profile-edit";
    }

    @PostMapping("/save")
    public String saveProfile(@ModelAttribute("userProfile") UserProfile profile, Integer userId, Model userModel, Model userProfileModel) {
        if (userId == null) {
            userId = 0;
        } else {
            userId.intValue();
        }

        User user = userService.findById(userId);
        Model theUserModel = userModel.addAttribute("user", user);

        // save the employee
        userProfileService.create(profile);

        UserProfile userProfile = userProfileService.findById(userId);
        Model theUserProfileModel = userProfileModel.addAttribute("userProfile", userProfile);

        // use a redirect to prevent duplicate submissions
        return "/admin/profile-log-in";
    }
    @PostMapping("/saveUser")
    public String saveUserProfile(@ModelAttribute("userProfile") UserProfile profile, Integer userId, Model userModel, Model userProfileModel) {
        if (userId == null) {
            userId = 0;
        } else {
            userId.intValue();
        }

        User user = userService.findById(userId);
        Model theUserModel = userModel.addAttribute("user", user);

        // save the employee
        userProfileService.create(profile);

        UserProfile userProfile = userProfileService.findById(userId);
        Model theUserProfileModel = userProfileModel.addAttribute("userProfile", userProfile);

        // use a redirect to prevent duplicate submissions
        return "/profile-log-in";
    }

}

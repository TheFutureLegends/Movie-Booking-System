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
    @RequestMapping("/login/edit")
    public String edit(@RequestParam("userId")int theId, Model userModel, Model userProfileModel){
        User user = userService.findById(theId);
        UserProfile userProfile = userProfileService.findById(theId);
        Model theUserModel = userModel.addAttribute("user", user);
        Model theUserProfileModel = userProfileModel.addAttribute("userProfile", userProfile);
        return "profile-edit";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        UserProfile userProfile = new UserProfile();

        theModel.addAttribute("userProfile", userProfile);

        return "admin/user_profile/add-update-form";
    }

    @PostMapping("/save")
    public String saveProfile(@ModelAttribute("userProfile") UserProfile profile) {

        // save the employee
        userProfileService.create(profile);

        // use a redirect to prevent duplicate submissions
        return "redirect:/profile/login";
    }

}

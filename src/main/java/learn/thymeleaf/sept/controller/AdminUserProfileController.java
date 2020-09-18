package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.UserProfile;
import learn.thymeleaf.sept.service.UserProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/user_profile")
public class AdminUserProfileController {

    private final UserProfileService userProfileService;

    public AdminUserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping("/list")
    public String listUserProfile(Model theModel, String keyword) {

        // get user from db
        List<UserProfile> userProfiles = userProfileService.findAll();
        // check if there is a search keyword
        if(keyword != null){
            theModel.addAttribute("userProfiles", userProfileService.findByUserProfileName(keyword));
        }
        else {
            // add to the spring model
            theModel.addAttribute("userProfiles", userProfiles);
        }

        return "admin/user_profile/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userProfileId")int theId, Model theModel){
        //get the user from service
        UserProfile userProfile = userProfileService.findById(theId);
        //set the user as a model attribute to pre-populate the form
        theModel.addAttribute("userProfile", userProfile);
        // send over to our form
        return "admin/user_profile/add-update-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userProfileId")int theId){
        //get the employee
        userProfileService.deleteById(theId);
        //redirect to list
        return "redirect:/admin/user_profile/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        UserProfile userProfile = new UserProfile();

        theModel.addAttribute("userProfile", userProfile);

        return "admin/user_profile/add-update-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("userProfile") UserProfile userProfile) {

        // save the user
        userProfileService.create(userProfile);

        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/user_profile/list";
    }
}
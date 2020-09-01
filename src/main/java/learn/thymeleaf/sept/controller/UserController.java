package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.User;
import learn.thymeleaf.sept.iterator.UserList;
import learn.thymeleaf.sept.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String userLogin(String userName, String password) {

        // get user from db
        List<User> users = userService.findAll();
        UserList userList = new UserList();
        userList.setUsers(users);
        int i = 0;

        while(userList.hasNext()) {
            if (userName.equals(userList.getUsers().get(i).getUserName())) {
                if (password.equals(userList.getUsers().get(i).getPassword())) {
                    return "homepage-log-in";
                }
            }
            i++;
            userList.next();
        }
        return "index";
    }

}


package learn.thymeleaf.sept.controller;

import learn.thymeleaf.sept.entity.User;
import learn.thymeleaf.sept.iterator.UserList;
import learn.thymeleaf.sept.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String userLogin(String userName, String password, Model theModel, HttpServletResponse response) throws IOException {

        // get user from db
        List<User> users = userService.findAll();
        UserList userList = new UserList();
        userList.setUsers(users);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();


        int i = 0;
        int tempId;

        while(userList.hasNext()) {
            if (userName.equals(userList.getUsers().get(i).getUserName())) {
                if (password.equals(userList.getUsers().get(i).getPassword())) {
                    if (userList.getUsers().get(i).getRole().equals("admin")) {
                        tempId = userList.getUsers().get(i).getId();
                        User user = userService.findById(tempId);
                        theModel.addAttribute("user", user);
                        return "admin/homepage-log-in";
                    } else {
                        tempId = userList.getUsers().get(i).getId();
                        User user = userService.findById(tempId);
                        theModel.addAttribute("user", user);
                        return "homepage-log-in";
                    }
                } else {
                    out.println("<script>alert('Wrong username or password'); location.href='/home/index';</script>");
                    out.flush();
                    return "redirect:/home/index";
                }
            }
            i++;
            userList.next();
        }
        out.println("<script>alert('Wrong username or password'); location.href='/home/index';</script>");
        out.flush();
        return "redirect:/home/index";
    }

}


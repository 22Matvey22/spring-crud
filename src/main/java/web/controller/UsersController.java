package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserDetailsServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    public UsersController(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @GetMapping
    public String index(Model model) {
        List<User> userList = userDetailsServiceImpl.getAllUsers();
        model.addAttribute("welcomeUser", userList);
        return "index";
    }

//    @GetMapping("profile/{id}")
//    public String showProfile(@PathVariable("id") Long id, Model model) {
//        User user = userDetailsServiceImpl.getUserById(id);
//        model.addAttribute("user", user);
//        return "profile";
//    }

    @GetMapping("admin")
    public String showUsers(Model model) {
        List<User> userList = userDetailsServiceImpl.getAllUsers();
        model.addAttribute("users", userList);
        return "show";
    }
//
//    @GetMapping("admin/new")
//    public String createUserForm(Model model) {
//        model.addAttribute("user", new User());
//        return "new";
//    }

//    @PostMapping("admin")
//    public String createUser(@ModelAttribute("user") User user) {
//        userDetailsServiceImpl.addUser(user);
//        return "redirect:/users";
//    }
//
//    @DeleteMapping("admin/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        userDetailsServiceImpl.removeUserById(id);
//        return "redirect:/users";
//    }
//
//    @GetMapping("admin/{id}/edit")
//    public String edit(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("user", userDetailsServiceImpl.getUserById(id));
//        return "edit";
//    }
//
//    @PatchMapping("admin/{id}")
//    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
//        userDetailsServiceImpl.updateUser(user);
//        return "redirect:/users";
//    }

}

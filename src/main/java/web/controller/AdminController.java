package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.Role;
import web.models.User;
import web.repositories.RoleRepository;
import web.service.UserService;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {
    private final UserService userService;
    private  final RoleRepository roleRepository;

    @Autowired
    public AdminController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("welcomeUser", userList);
        return "index";
    }


    @GetMapping("/admin")
    public String showUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "show";
    }

    @GetMapping(value = "/admin/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/admin")
    public String createUser(@ModelAttribute("user") User user,
                             @RequestParam(value = "role", required = false) String role) {
        if (role != null) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.getById(1L)); //добавляю ROLE_USER
            roles.add(roleRepository.getById(2L)); //добавляю ROLE_ADMIN
            user.setRoles(roles);
        } else {
            user.setRoles(Collections.singleton(roleRepository.getById(1L))); //добавляю только ROLE_USER
        }
        userService.addUser(user);
        return "redirect:/admin";
    }

//    @PostMapping("/admin")
//    public String createUser(@RequestParam("username") String username,
//                             @RequestParam("password") String password,
//                             @RequestParam("firstName") String firstName,
//                             @RequestParam("lastName") String lastName,
//                             @RequestParam("email") String email,
//                             @RequestParam(value = "role", required = false) String role,
//                             Model model) {
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setEmail(email);
//        if(role != null){
//            Set<Role> roles = new HashSet<>();
//            roles.add(new Role(1L, "ROLE_USER"));
//            roles.add(new Role(2L, "ROLE_ADMIN"));
//            user.setRoles(roles);
//        } else {
//            user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
//        }
//        userService.addUser(user);
//        model.addAttribute("user", user);
//        return "redirect:/admin";
//    }

    @DeleteMapping("/admin/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/admin/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(user);
        return "redirect:/admin";
    }
}

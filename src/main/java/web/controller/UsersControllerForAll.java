package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersControllerForAll {
    private final UserService userService;
    private final String redirect = "redirect:/";

    @Autowired
    public UsersControllerForAll(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "home";
    }

    @GetMapping(value = "/create")
    public String createNewUserPage(Model model) {
        model.addAttribute("user", new User());
        return "createNew";
    }

    @PostMapping(value = "create")
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.create(user);
        return redirect;
    }

    @GetMapping(value = "/{id}")
    public String readUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute(userService.read(id));
        return "readUser";
    }

    @GetMapping(value = "/{id}/update")
    public String updateUserPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.read(id));
        return "upadateUser";
    }

    @PatchMapping(value = "/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id, Model model) {
        userService.update(user);
        return redirect;
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return redirect;
    }
}


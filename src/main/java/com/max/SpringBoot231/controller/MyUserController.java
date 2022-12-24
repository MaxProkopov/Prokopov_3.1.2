package com.max.SpringBoot231.controller;

import com.max.SpringBoot231.model.User;
import com.max.SpringBoot231.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MyUserController {

    private UserService userService;

    @Autowired
    public MyUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String users(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }
    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userInfo";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "userInfo";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}

package com.safecampus.safecampus.controller;

import com.safecampus.safecampus.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final com.safecampus.safecampus.service.UserService userService;

    public AuthController(com.safecampus.safecampus.service.UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User loggedUser = userService.login(user.getUsername(), user.getPassword());

        if (loggedUser != null) {
            return "Login Successful - Role: " + loggedUser.getRole();
        }

        return "Invalid Username or Password";
    }
}
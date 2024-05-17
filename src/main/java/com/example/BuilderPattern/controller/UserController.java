package com.example.BuilderPattern.controller;

import com.example.BuilderPattern.dto.User;
import com.example.BuilderPattern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{name}")
    public User findByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    @PostMapping("/builder")
    public void userBuilder() {
        userService.userBuilder();
    }

    @PostMapping("/builder/email")
    public void userBuilderForEmail() {
        userService.userBuilderForEmail();
    }

}

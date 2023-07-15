package com.example.CuddleCare.web;

import com.example.CuddleCare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public boolean checkEmailExist(@RequestParam(value = "email", defaultValue = "") String email){
        return userService.loadUSerUserByEmail(email) != null;
    }
}

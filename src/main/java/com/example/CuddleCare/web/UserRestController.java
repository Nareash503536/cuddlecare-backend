package com.example.CuddleCare.web;

import com.example.CuddleCare.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/users")
//    public boolean checkEmailExist(@RequestParam(value = "username", defaultValue = "") String username){
//        return userService.loadUserByUsername(username) != null;
//    }

    @GetMapping("/users")
    public boolean checkEmailExist(){
        return true;
    }
}

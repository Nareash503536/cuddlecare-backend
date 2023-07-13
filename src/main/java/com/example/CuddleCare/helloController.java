package com.example.CuddleCare;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    @GetMapping("/home")
    public String helloWorld(){
        return "Hello World";
    }
}

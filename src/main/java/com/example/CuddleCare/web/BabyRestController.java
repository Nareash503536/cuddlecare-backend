package com.example.CuddleCare.web;

import com.example.CuddleCare.entity.Baby;
import com.example.CuddleCare.service.BabyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class BabyRestController {
    private BabyService babyService;

    public BabyRestController(BabyService babyService) {
        this.babyService = babyService;
    }

    @PostMapping("/updateBabyByAttribute")
    public Baby updateBaby(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "attribute") String attribute,
            @RequestParam(name = "value") String value) {
        return babyService.updateBabyByAttribute(id, attribute, value);
    }

    @PostMapping("/setBabyPicture")
    public Baby setProfilePicture(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "profilePicture") String profilePicture) {
        Baby baby = babyService.loadBabyById(id);
        baby.setBabyPicture(profilePicture);
        return babyService.updateBaby(baby);
    }

    @PostMapping("/removeBabyPicture")
    public Baby removeProfilePicture(@RequestParam(name = "id") Long id){
        Baby baby = babyService.loadBabyById(id);
        baby.setBabyPicture(null);
        return babyService.updateBaby(baby);
    }
}

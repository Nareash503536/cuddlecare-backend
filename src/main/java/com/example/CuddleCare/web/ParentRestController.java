package com.example.CuddleCare.web;

import com.example.CuddleCare.dto.BabyDTO;
import com.example.CuddleCare.dto.ParentDTO;
import com.example.CuddleCare.dto.UserDTO;
import com.example.CuddleCare.entity.User;
import com.example.CuddleCare.service.BabyService;
import com.example.CuddleCare.service.ParentService;
import com.example.CuddleCare.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
 @CrossOrigin("*")
public class ParentRestController {
    private ParentService parentService;
    private BabyService babyService;
    private UserService userService;

    public ParentRestController(
            ParentService parentService,
            BabyService babyService,
            UserService userService) {
        this.parentService = parentService;
        this.babyService = babyService;
        this.userService = userService;
    }

    public ParentDTO createParentDTO(
            String ParentEmail,
            String ParentPassword,
            String ParentName,
            String ParentDOB,
            String ParentPhoneNumber,
            String BabyRelationship) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(ParentName);
        userDTO.setPassword(ParentPassword);
        userDTO.setEmail(ParentEmail);
        userDTO.setDob(ParentDOB);
        userDTO.setContactNumber(ParentPhoneNumber);
        if (BabyRelationship == "father")
            userDTO.setGender("male");
        else
            userDTO.setGender("female");
        userDTO.setRelationship(BabyRelationship);
        ParentDTO parentDTO = new ParentDTO();
        parentDTO.setUser(userDTO);
        return parentDTO;
    }

    public BabyDTO createBabyDTO(
            String BabyDOB,
            String BabyGender,
            String BabyName) {
        BabyDTO babyDTO = new BabyDTO();
        babyDTO.setDob(BabyDOB);
        babyDTO.setGender(BabyGender);
        babyDTO.setBabyName(BabyName);
        return babyDTO;
    }

    @PostMapping("/register/parent")
    public boolean registerParent(@RequestParam("BabyDOB") String BabyDOB,
            @RequestParam("BabyGender") String BabyGender,
            @RequestParam("BabyName") String BabyName,
            @RequestParam("BabyRelationship") String BabyRelationship,
            @RequestParam("ParentName") String ParentName,
            @RequestParam("ParentPhoneNumber") String ParentPhoneNumber,
            @RequestParam("ParentDOB") String ParentDOB,
            @RequestParam("ParentEmail") String ParentEmail,
            @RequestParam("ParentPassword") String ParentPassword) {
         User user = userService.loadUserByEmail(ParentEmail);
         if (user != null) throw new RuntimeException("Parent already exists");
        ParentDTO parentDto = createParentDTO(
                ParentEmail,
                ParentPassword,
                ParentName,
                ParentDOB,
                ParentPhoneNumber,
                BabyRelationship);
        ParentDTO savedParent = parentService.createParent(parentDto);
         BabyDTO savedBaby = babyService.createBaby(
             BabyGender,
             BabyDOB,
             BabyName
         );
         babyService.addBabyToParent(savedBaby, savedParent);
        return savedBaby != null && savedParent != null;
    }
}
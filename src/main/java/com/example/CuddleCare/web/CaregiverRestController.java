package com.example.CuddleCare.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CuddleCare.dto.BabyDTO;
import com.example.CuddleCare.dto.ParentDTO;
import com.example.CuddleCare.dto.UserDTO;
import com.example.CuddleCare.dto.CaregiverDTO;
import com.example.CuddleCare.entity.Caregiver;
import com.example.CuddleCare.entity.User;
import com.example.CuddleCare.service.CaregiverService;
import com.example.CuddleCare.service.UserService;


@RestController
@CrossOrigin("*")
public class CaregiverRestController {

    private CaregiverService caregiverService;
    private UserService userService;

    public CaregiverRestController(CaregiverService caregiverService,
            UserService userService) {
        this.caregiverService = caregiverService;
        this.userService = userService;
    }

    public CaregiverDTO createCaregiverDTO(
            String CaregiverName,
            String CaregiverPhoneNumber,
            String CaregiverDOB,
            String CaregiverGender,
            String CaregiverPassword,
            String CaregiverEmail
            ) {
            UserDTO user = new UserDTO();
            user.setUsername(CaregiverName);
            user.setPassword(CaregiverPassword);
            user.setEmail(CaregiverEmail);
            user.setDob(CaregiverDOB);
            user.setContactNumber(CaregiverPhoneNumber);
            user.setGender(CaregiverGender);
            user.setRelationship("Caregiver");
            CaregiverDTO newCaregiver = new CaregiverDTO();
            newCaregiver.setUser(user);
            return newCaregiver;
        }

    @PostMapping("/register/caregiver")
    public CaregiverDTO registerParent(@RequestParam("CaregiverName") String CaregiverName,
            @RequestParam("CaregiverPhoneNumber") String CaregiverPhoneNumber,
            @RequestParam("CaregiverDOB") String CaregiverDOB,
            @RequestParam("CaregiverGender") String CaregiverGender,
            @RequestParam("CaregiverPassword") String CaregiverPassword,
            @RequestParam("CaregiverEmail") String CaregiverEmail
            ) {
        User user = userService.loadUserByEmail(CaregiverEmail);
        if (user != null)
            throw new RuntimeException("Caregiver already exists");
        CaregiverDTO caregiverDto = createCaregiverDTO(
                CaregiverName,
                CaregiverPhoneNumber,
                CaregiverDOB,
                CaregiverGender,
                CaregiverPassword,
                CaregiverEmail);
        CaregiverDTO savedCaregiver = caregiverService.createCaregiver(caregiverDto);
        return savedCaregiver;
    }
    
}

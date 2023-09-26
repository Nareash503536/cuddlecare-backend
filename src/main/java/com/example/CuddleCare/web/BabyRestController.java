package com.example.CuddleCare.web;

import com.example.CuddleCare.dto.BabyDTO;
import com.example.CuddleCare.dto.CaregiverDTO;
import com.example.CuddleCare.dto.ParentDTO;
import com.example.CuddleCare.entity.Baby;
import com.example.CuddleCare.entity.Caregiver;
import com.example.CuddleCare.mapper.BabyMapper;
import com.example.CuddleCare.mapper.CaregiverMapper;
import com.example.CuddleCare.service.BabyService;
import com.example.CuddleCare.service.ParentService;
import com.example.CuddleCare.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BabyRestController {
    private BabyService babyService;
    private ParentService parentService;
    private UserService userService;
    private BabyMapper babyMapper;
    private CaregiverMapper caregiverMapper;

    public BabyRestController(
            BabyService babyService,
            ParentService parentService,
            UserService userService,
            BabyMapper babyMapper,
            CaregiverMapper caregiverMapper) {
        this.babyService = babyService;
        this.parentService = parentService;
        this.babyMapper = babyMapper;
        this.userService = userService;
        this.caregiverMapper = caregiverMapper;
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
            @RequestParam(name = "babyPicture") String profilePicture) {
        Baby baby = babyService.loadBabyById(id);
        baby.setBabyPicture(profilePicture);
        return babyService.updateBaby(baby);
    }

    @PostMapping("/removeBabyPicture")
    public Baby removeProfilePicture(@RequestParam(name = "id") Long id) {
        Baby baby = babyService.loadBabyById(id);
        baby.setBabyPicture(null);
        return babyService.updateBaby(baby);
    }

    @PostMapping("/deleteBaby")
    public ResponseEntity<String> deleteBaby(@RequestParam(name = "id") Long id) {
        Baby baby = babyService.loadBabyById(id);
        babyService.deleteBaby(baby);

        return ResponseEntity.ok("Baby deleted");
    }

    @PostMapping("/addBaby")
    public Baby addBaby(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "dob") String dob,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "gender") String gender) {
        ParentDTO parentDTO = parentService.loadParentDTOByUser(userService.loadUserByEmail(email));
        Baby newBaby = babyService.addBaby(new Baby(gender, dob, name));
        BabyDTO babyDTO = babyMapper.FromBaby(newBaby);
        babyService.addBabyToParent(babyDTO, parentDTO);
        return newBaby;
    }

    @PostMapping("/requestToCaregive")
    public CaregiverDTO requestToCaregiveBaby(
            @RequestParam(name = "caregiverID") Long caregiverID,
            @RequestParam(name = "babyID") Long babyID) {
        Caregiver caregiver = babyService.requestToCaregiveBaby(babyID, caregiverID);
        return caregiverMapper.FromCaregiver(caregiver);
    }

    @PostMapping("/removeRequest")
    public CaregiverDTO removeRequest(
            @RequestParam(name = "caregiverID") Long caregiverID,
            @RequestParam(name = "babyID") Long babyID) {
        Caregiver caregiver = babyService.rejectRequest(babyID, caregiverID);
        return caregiverMapper.FromCaregiver(caregiver);
    }

    @PostMapping("/removeCaregiver")
    public Baby removeCaregiver(
            @RequestParam(name = "caregiverID") Long caregiverID,
            @RequestParam(name = "babyID") Long babyID) {
        return babyService.removeCaregiver(babyID, caregiverID);
    }

    @PostMapping("/getRequestedCaregivers")
    public ResponseEntity<List<Caregiver>> getRequestedCaregivers(
            @RequestParam(name = "babyID") Long babyID) {
        return ResponseEntity.ok(babyService.getCaregiverRequestList(babyID));
    }

    @PostMapping("/getCurrentCaregiver")
    public Caregiver getCurrentCaregiver(
            @RequestParam(name = "babyID") Long babyID) {
        Baby baby = babyService.loadBabyById(babyID);
        return baby.getCaregiver();
    }

    @PostMapping("/acceptBabyRequest")
    public Baby acceptCaregiverRequest(
            @RequestParam(name = "babyID") Long babyID,
            @RequestParam(name = "email") String email) {
        return babyService.acceptBabyRequest(babyID, email);
    }

    @PostMapping("/cancelBabyRequest")
    public Baby cancelBabyRequest(
            @RequestParam(name = "babyID") Long babyID,
            @RequestParam(name = "email") String email) {
        return babyService.cancelBabyRequest(babyID, email);
    }
}
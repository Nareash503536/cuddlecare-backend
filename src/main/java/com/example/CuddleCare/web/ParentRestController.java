package com.example.CuddleCare.web;

import com.example.CuddleCare.dto.BabyDTO;
import com.example.CuddleCare.dto.ParentDTO;
import com.example.CuddleCare.dto.UserDTO;
import com.example.CuddleCare.entity.User;
import com.example.CuddleCare.exceptions.UserException;
import com.example.CuddleCare.mapper.UserMapper;
import com.example.CuddleCare.service.BabyService;
import com.example.CuddleCare.service.ParentService;
import com.example.CuddleCare.service.RoleService;
import com.example.CuddleCare.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
 @CrossOrigin("*")
public class ParentRestController {
    private ParentService parentService;
    private BabyService babyService;
    private UserService userService;
    private RoleService roleService;
    private UserMapper userMapper;

    public ParentRestController(
            ParentService parentService,
            BabyService babyService,
            UserService userService,
            RoleService roleService,
            UserMapper userMapper) {
        this.parentService = parentService;
        this.babyService = babyService;
        this.userService = userService;
        this.roleService = roleService;
        this.userMapper = userMapper;
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
    public ResponseEntity<UserException> registerParent(
            @RequestParam("BabyDOB") String BabyDOB,
            @RequestParam("BabyGender") String BabyGender,
            @RequestParam("BabyName") String BabyName,
            @RequestParam("BabyRelationship") String BabyRelationship,
            @RequestParam("ParentName") String ParentName,
            @RequestParam("ParentPhoneNumber") String ParentPhoneNumber,
            @RequestParam("ParentDOB") String ParentDOB,
            @RequestParam("ParentEmail") String ParentEmail,
            @RequestParam("ParentPassword") String ParentPassword) {
         User user = userService.loadUserByEmail(ParentEmail);
        UserException UserException = new UserException();
        ParentDTO savedParent;
        if (user != null && user.getRoles().contains(roleService.getRoleByName("Parent"))){
             UserException.setResult("Parent already exists");
             UserException.setError(true);
             return ResponseEntity.ok(UserException);
         } else if(user != null && user.getRoles().contains(roleService.getRoleByName("Caregiver"))){
            userService.AssignRoleToUser(ParentEmail, "Parent");
            ParentDTO parentDTO = new ParentDTO();
            parentDTO.setUser(userMapper.FromUser(user));
            savedParent = parentService.assignParentRole(parentDTO);
        } else {
            ParentDTO parentDto = createParentDTO(
                    ParentEmail,
                    ParentPassword,
                    ParentName,
                    ParentDOB,
                    ParentPhoneNumber,
                    BabyRelationship);
            savedParent = parentService.createParent(parentDto);
        }
        BabyDTO savedBaby = babyService.createBaby(
                BabyGender,
                BabyDOB,
                BabyName
        );
        babyService.addBabyToParent(savedBaby, savedParent);
        if(savedParent != null && savedBaby != null){
            UserException.setResult("Parent and Baby created successfully");
            UserException.setError(false);
        } else {
            UserException.setResult("Parent and Baby creation failed");
            UserException.setError(true);
        }
        return ResponseEntity.ok(UserException);
    }
}
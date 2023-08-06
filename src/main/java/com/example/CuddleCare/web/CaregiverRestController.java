package com.example.CuddleCare.web;

import com.example.CuddleCare.dto.CaregiverDTO;
import com.example.CuddleCare.dto.UserDTO;
import com.example.CuddleCare.entity.User;
import com.example.CuddleCare.exceptions.UserException;
import com.example.CuddleCare.mapper.UserMapper;
import com.example.CuddleCare.service.CaregiverService;
import com.example.CuddleCare.service.RoleService;
import com.example.CuddleCare.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CaregiverRestController {

    private CaregiverService caregiverService;
    private UserService userService;
    private RoleService roleService;
    private UserMapper userMapper;

    public CaregiverRestController(
            CaregiverService caregiverService,
            UserService userService,
            RoleService roleService,
            UserMapper userMapper) {
        this.caregiverService = caregiverService;
        this.userService = userService;
        this.roleService = roleService;
        this.userMapper = userMapper;
    }

    public CaregiverDTO createCaregiverDTO(
            String CaregiverName,
            String CaregiverPhoneNumber,
            String CaregiverDOB,
            String CaregiverGender,
            String CaregiverPassword,
            String CaregiverEmail) {
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
    public ResponseEntity<UserException> registerCaregiver(
            @RequestParam("CaregiverName") String CaregiverName,
            @RequestParam("CaregiverPhoneNumber") String CaregiverPhoneNumber,
            @RequestParam("CaregiverDOB") String CaregiverDOB,
            @RequestParam("CaregiverGender") String CaregiverGender,
            @RequestParam("CaregiverPassword") String CaregiverPassword,
            @RequestParam("CaregiverEmail") String CaregiverEmail) {
        UserException UserException = new UserException();
        User user = userService.loadUserByEmail(CaregiverEmail);
        CaregiverDTO savedCaregiver;
        if (user != null && user.getRoles().contains(roleService.getRoleByName("Caregiver"))) {
            UserException.setResult("Caregiver already exists");
            UserException.setError(true);
            return ResponseEntity.ok(UserException);
        } else if(user != null && user.getRoles().contains(roleService.getRoleByName("Parent"))) {
            userService.AssignRoleToUser(CaregiverEmail, "Caregiver");
            CaregiverDTO caregiverDTO = new CaregiverDTO();
            caregiverDTO.setUser(userMapper.FromUser(user));
            savedCaregiver = caregiverService.assignCaregiverRole(caregiverDTO);
        } else {
            CaregiverDTO caregiverDto = createCaregiverDTO(
                    CaregiverName,
                    CaregiverPhoneNumber,
                    CaregiverDOB,
                    CaregiverGender,
                    CaregiverPassword,
                    CaregiverEmail);
            savedCaregiver = caregiverService.createCaregiver(caregiverDto);
        }
        if(savedCaregiver != null){
            UserException.setResult("Caregiver created successfully");
            UserException.setError(false);
        } else{
            UserException.setResult("Caregiver creation failed");
            UserException.setError(true);
        }
        return ResponseEntity.ok(UserException);
    }

}

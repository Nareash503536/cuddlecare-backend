// new class UserDTO

package com.example.CuddleCare.dto;

import com.example.CuddleCare.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserDTO{
    private String username;
    private String password;
    private String email;
    private String nic;
    private String address;
    private Date dob;
    private List<Role> roles;
    
}



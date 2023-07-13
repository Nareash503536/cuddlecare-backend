// new interface UserService

package com.example.CuddleCare.service;

import com.example.CuddleCare.entity.User;

import java.util.Date;

public interface UserService {

    User loadUserByUsername(String username);

    User createUser(String username, 
                    String password, 
                    String email, 
                    String nic,
                    String address,
                    Date dob);

    void AssignRoleToUser(String email, String roleName);
}




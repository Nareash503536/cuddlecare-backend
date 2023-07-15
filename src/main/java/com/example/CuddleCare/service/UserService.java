// new interface UserService

package com.example.CuddleCare.service;

import com.example.CuddleCare.entity.User;

import java.util.List;

public interface UserService {

    User loadUserByUsername(String username);

    List<User> getAllUsers();

    User loadUserByEmail(String email);

    User createUser(String username, 
                    String password, 
                    String email, 
                    String nic,
                    String address,
                    String dob);

    void AssignRoleToUser(String email, String roleName);
}




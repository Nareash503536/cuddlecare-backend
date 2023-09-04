// new interface UserService

package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.UserDTO;
import com.example.CuddleCare.entity.User;

import java.util.List;

public interface UserService {

    User loadUserByUsername(String username);

    List<User> getAllUsers();

    User loadUserByEmail(String email);

    User createUser(UserDTO userDTO);

    void AssignRoleToUser(String email, String roleName);

    void authenticateUser(String email);

    User updateUser(User user);

    User updateUserByAttribute(String email, String attribute, String value);

}




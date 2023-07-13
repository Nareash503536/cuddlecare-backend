package com.example.CuddleCare.mapper;


import com.example.CuddleCare.dto.UserDTO;
import com.example.CuddleCare.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User FromUserDto(UserDTO userDto) {
        User user = new User();
        user.setUserName(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setNic(userDto.getNic());
        user.setAddress(userDto.getAddress());
        user.setDob(userDto.getDob());
        return user;
    }
     
    public UserDTO FromUser(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setUsername(user.getUserName());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setNic(user.getNic());
        userDto.setAddress(user.getAddress());
        userDto.setDob(user.getDob());
        return userDto;
    }
    }
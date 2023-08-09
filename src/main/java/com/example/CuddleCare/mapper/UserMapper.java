package com.example.CuddleCare.mapper;


import com.example.CuddleCare.dto.UserDTO;
import com.example.CuddleCare.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User FromUserDto(UserDTO userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }
     
    public UserDTO FromUser(User user) {
        UserDTO userDto = new UserDTO();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
    }
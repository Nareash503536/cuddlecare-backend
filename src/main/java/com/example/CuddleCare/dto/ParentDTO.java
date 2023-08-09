package com.example.CuddleCare.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentDTO {
    private Long parentID;
    private UserDTO user;

    public void setUser(UserDTO user){
        this.user = user;
    }

    public UserDTO getUser(){
        return user;
    }
}

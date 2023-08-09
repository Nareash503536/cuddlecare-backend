package com.example.CuddleCare.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaregiverDTO{
    private Long caregiverID;

    private UserDTO user;

    public void setUser(UserDTO userDTO) {
        this.user = userDTO;
    }

    public UserDTO getUser() {
        return user;
    }
}
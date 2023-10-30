package com.example.CuddleCare.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CaregiverDTO{
    private Long caregiverID;
    private UserDTO user;
    private Set<BabyDTO> babies = new HashSet<>();
    private Set<BabyDTO> requestedBabies = new HashSet<>();


    public void setUser(UserDTO userDTO) {
        this.user = userDTO;
    }
    public UserDTO getUser() {
        return user;
    }


    public void setBabies(Set<BabyDTO> babies) {
        this.babies = babies;
    }
    public Set<BabyDTO> getBabies() {
        return babies;
    }


    public void setRequestedBabies(Set<BabyDTO> requestedBabies) {
        this.requestedBabies = requestedBabies;
    }
    public Set<BabyDTO> getRequestedBabies() {
        return requestedBabies;
    }
}
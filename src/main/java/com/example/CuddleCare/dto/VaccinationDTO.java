package com.example.CuddleCare.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class VaccinationDTO {
    private Long vaccinationID;
    private String name;
    private String category;
    private Integer months;
    private Set<BabyDTO> babies = new HashSet<>();

    public Set<BabyDTO> getBabies() {
        return babies;
    }
    public void setBabies(Set<BabyDTO> babies) {
        this.babies = babies;
    }
}

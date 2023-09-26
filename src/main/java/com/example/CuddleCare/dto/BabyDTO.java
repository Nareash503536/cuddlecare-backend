package com.example.CuddleCare.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class BabyDTO {
    private Long babyID;
    private String babyName;
    private String dob;
    private String gender;
    private Set<ParentDTO> parents = new HashSet<>();

    public void setParents(Set<ParentDTO> parents){
        this.parents = parents;
    }
    public Set<ParentDTO> getParents(){
        return this.parents;
    }
}

package com.example.CuddleCare.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ParentDTO {
    private Long parentID;
    private UserDTO user;
    private Boolean proAccess;
//    private Set<ReminderDTO> reminders = new HashSet<>();
//    private Set<PostDTO> posts = new HashSet<>();
//    private Set<ReactionDTO> reactions = new HashSet<>();
//    private Set<CommentDTO> comments = new HashSet<>();
    private Set<BabyDTO> babies = new HashSet<>();
    public void setUser(UserDTO user){
        this.user = user;
    }

    public UserDTO getUser(){
        return user;
    }
}

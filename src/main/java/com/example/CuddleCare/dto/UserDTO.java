// new class UserDTO

package com.example.CuddleCare.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO{
    private Long userID;
    private String username;
    private String password;
    private String email;
    private String dob;
    private String contactNumber;
    private String gender;
    private String relationship;
    private String profilePicture;
    // private String authenticated;
    // private Set<Role> roles = new HashSet<>();
    // private Admin admin;
    // private Caregiver caregiver;
    // private Parents parent;
    // private ContentManager contentManager;
    // private GuestUser guestuser;
}
package com.example.CuddleCare.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userID;

    @Basic
    @Column(name = "user_name", unique = true, nullable = false)
    private String username;

    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    @Basic
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Basic
    @Column(name = "gender")
    private String gender;

    @Basic
    @Column(name = "dob")
    private String dob;

    @Basic
    @Column(name = "relationship", nullable = true)
    private String relationship;

    @Basic
    @Column(name = "authenticated")
    private boolean authenticated;

    @Basic
    @Column(name = "contact_number")
    private String contactNumber;

    @Basic
    @Column(name = "profile_picture")
    private String profilePicture;

    //Foreign classes
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
                joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
                inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Admin admin;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Caregiver caregiver;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Parents parent;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private ContentManager contentManager;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private GuestUser guestuser;

    public User(String username,
                String encodedPassword,
                String email,
                String dob,
                String contactNumber,
                String gender,
                String relationship) {
        this.username = username;
        this.password = encodedPassword;
        this.email = email;
        this.dob = dob;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.relationship = relationship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userID, user.userID) && Objects.equals(password, user.password)  && Objects.equals(email, user.email)  && Objects.equals(dob, user.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, password, email, dob);
    }

    public void assignRoleToUser(Role role) {
        this.roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRoleFromUser(Role role) {
        this.roles.remove(role);
    }

}
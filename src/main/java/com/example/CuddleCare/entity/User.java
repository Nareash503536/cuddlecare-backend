package com.example.CuddleCare.entity;

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
    private String userName;

    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    @Basic
    @Column(name = "nic", unique = true, nullable = false)
    private String nic;

    @Basic
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "dob")
    private String dob;

    //Foreign classes
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

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Parents parent;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private ContentManager contentManager;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private GuestUser guestuser;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userID, user.userID) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(nic, user.nic) && Objects.equals(email, user.email) && Objects.equals(address, user.address) && Objects.equals(dob, user.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, userName, password, nic, email, address, dob);
    }

    public void assignRoleToUser(Role role) {
        this.roles.add(role);
    }

    public void removeRoleFromUser(Role role) {
        this.roles.remove(role);
    }

    public User(String userName, String password, String nic, String email, String address, String dob) {
        this.userName = userName;
        this.password = password;
        this.nic = nic;
        this.email = email;
        this.address = address;
        this.dob = dob;
    }

}
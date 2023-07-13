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
@Table(name = "guestuser")
public class GuestUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guestuser_id", nullable = false)
    private Long guestuserID;

    @OneToMany(mappedBy = "guestUser", cascade = CascadeType.ALL)
    private Set<Advertisement> advertisements = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuestUser guestUser = (GuestUser) o;
        return Objects.equals(guestuserID, guestUser.guestuserID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestuserID);
    }
}

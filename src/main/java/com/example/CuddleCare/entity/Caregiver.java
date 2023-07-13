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
@Table(name = "caregiver")
public class Caregiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caregiver_id", nullable = false)
    private Long careGiverID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caregiver caregiver = (Caregiver) o;
        return Objects.equals(careGiverID, caregiver.careGiverID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(careGiverID);
    }

    @OneToMany(mappedBy = "caregiver", cascade = CascadeType.ALL)
    private Set<Baby> babies = new HashSet<>();

    @OneToMany(mappedBy = "caregiver")
    private Set<ToDoList> toDoLists = new HashSet<>();

}

package com.example.CuddleCare.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "caregiver")
public class Caregiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caregiver_id", nullable = false)
    private Long caregiverID;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caregiver caregiver = (Caregiver) o;
        return Objects.equals(caregiverID, caregiver.caregiverID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caregiverID);
    }

    @JsonManagedReference
    @ManyToMany(mappedBy = "requestCaregiverSet")
    private Set<Baby> requestedBabies = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "caregiver", cascade = CascadeType.ALL)
    private Set<Baby> babies = new HashSet<>();

    @OneToMany(mappedBy = "caregiver")
    private Set<ToDoList> toDoLists = new HashSet<>();

    public void acceptCaregiverRequest(Baby baby){
        baby.removeCaregiverRequest(this);
        this.getBabies().add(baby);
        baby.setCaregiver(this);
    }

}

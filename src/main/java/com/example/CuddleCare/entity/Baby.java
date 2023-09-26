package com.example.CuddleCare.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Builder
@Entity
@Table(name = "baby")
public class Baby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baby_ID", nullable = false)
    private Long babyID;

    @Basic
    @Column(name = "gender")
    private String gender;

    @Basic
    @Column(name = "baby_picture")
    private String babyPicture;

    @Basic
    @Column(name = "dob")
    private String dob;

    @Basic
    @Column(name = "baby_Name", nullable = false)
    private String babyName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baby baby = (Baby) o;
        return Objects.equals(babyID, baby.babyID) && Objects.equals(babyName, baby.babyName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(babyID, babyName);
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caregiver_id", referencedColumnName = "caregiver_id")
    private Caregiver caregiver;

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinTable(name = "baby_request_caregiver",
        joinColumns = {@JoinColumn(name = "baby_ID", referencedColumnName = "baby_ID")},
        inverseJoinColumns = {@JoinColumn(name = "caregiver_id", referencedColumnName = "caregiver_id")}
    )
    private Set<Caregiver> requestCaregiverSet = new HashSet<>();

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL)
    private Set<Sleep> sleepSet = new HashSet<>();

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL)
    private Set<Milestone> milestoneSet = new HashSet<>();

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL)
    private Set<GrowthMeasurement> growthMeasurements = new HashSet<>();

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL)
    private Set<Expense> expenses = new HashSet<>();

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL)
    private Set<Diaper> diaperSet = new HashSet<>();

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL)
    private Set<Feeding> feedings = new HashSet<>();

    @OneToMany(mappedBy = "baby")
    private Set<ToDoList> toDoLists = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "babies")
    private Set<Parents> parents = new HashSet<>();

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL)
    private Set<SymptomBaby> symptomBaby = new HashSet<>();

    public Baby(String BabyGender, String BabyDOB, String BabyName){
        this.dob = BabyDOB;
        this.babyName = BabyName;
        this.gender = BabyGender;
    }

    public void addParentToBaby(Parents parent) {
        this.parents.add(parent);
        parent.getBabies().add(this);
    }

    public void addCaregiverRequest(Caregiver caregiver){
        this.requestCaregiverSet.add(caregiver);
        caregiver.getRequestedBabies().add(this);
    }

    public void removeCaregiverRequest(Caregiver caregiver){
        this.requestCaregiverSet.remove(caregiver);
        caregiver.getRequestedBabies().remove(this);
    }

    public void removeCaregiver(Caregiver caregiver){
        setCaregiver(null);
        caregiver.getBabies().remove(this);
    }

    public void acceptRequest(Caregiver caregiver){
        removeCaregiverRequest(caregiver);
        setCaregiver(caregiver);
        caregiver.getBabies().add(this);
    }
	
//	public Long getBabyId() {
//        if (babyID != null) {
//            return babyID;
//        }
//        return null;
//    }
//
//    public void setBabyId(Long babyId) {
//    }
}

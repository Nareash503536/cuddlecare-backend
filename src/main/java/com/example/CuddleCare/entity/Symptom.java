package com.example.CuddleCare.entity;

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
@Builder
@Entity
@Table(name = "symptom")
public class Symptom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "symptom_ID", nullable = false)
    private Long symptomID;

    @Basic
    @Column(name = "name")
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "symptom" ,cascade = CascadeType.ALL)
    private Set<SymptomBaby> symptomBaby = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symptom symptom = (Symptom) o;
        return Objects.equals(symptomID, symptom.symptomID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symptomID);
    }

    public Symptom(String name) {
    	this.name = name;
    }
}

package com.example.CuddleCare.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "vaccination")
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Vaccination_id", nullable = false)
    private Long vaccinationID;

    @Basic
    @Column(name="name")
    private String name;

    @Basic
    @Column(name="category")
    private String category;

    @Basic
    @Column(name="months")
    private Integer months;

    @ManyToMany(cascade=CascadeType.REMOVE)
    @JoinTable(name="baby_vaccination",
            joinColumns = {@JoinColumn(name="vaccination_id", referencedColumnName = "vaccination_id")},
            inverseJoinColumns = {@JoinColumn(name="baby_id", referencedColumnName = "baby_id")})
    private Set<Baby> babies = new HashSet<>();

}

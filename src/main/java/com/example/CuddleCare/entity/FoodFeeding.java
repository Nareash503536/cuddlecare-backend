package com.example.CuddleCare.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "foodfeeding")
public class FoodFeeding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id", nullable = false)
    private Long foodFeedingID;

    @Basic
    @Column(name = "mixture_name")
    private String mixtureName;

    @Basic
    @Column(name = "feedingdate")
    private Date feedingDate;

    @Basic
    @Column(name = "feedingtime")
    private String feedingTime;

    @Basic
    @Column(name = "reaction")
    private String reaction;


    @Basic
    @Column(name = "additional_notes")
    private String additionalNotes;

    @OneToMany(mappedBy = "foodFeeding")

    private Set<FoodIngredient> foodIngredients = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id", referencedColumnName = "baby_id")
    @JsonBackReference
    private Baby baby;
}

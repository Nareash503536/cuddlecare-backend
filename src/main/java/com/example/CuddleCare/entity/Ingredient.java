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
@ToString
@Builder
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false)
    private Long ingredientID;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "category")
    private String category;

    @Basic
    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "ingredient")
    @JsonManagedReference
    private Set<FoodIngredient> foodIngredients = new HashSet<>();


}

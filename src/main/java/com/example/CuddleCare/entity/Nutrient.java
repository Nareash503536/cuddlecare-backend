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
@Table(name = "nutrient")
public class Nutrient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nutrient_id", nullable = false)
    private Long nutrientID;

    @Basic
    @Column(name = "nutrient_name")
    private String nutrientName;

    @Basic
    @Column(name = "amount")
    private Double amount;

    @OneToMany(mappedBy = "nutrient", cascade = CascadeType.ALL)
    private Set<MealNutrient> mealNutrientSet = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nutrient nutrient = (Nutrient) o;
        return Objects.equals(nutrientID, nutrient.nutrientID) && Objects.equals(nutrientName, nutrient.nutrientName) && Objects.equals(amount, nutrient.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nutrientID, nutrientName, amount);
    }
}

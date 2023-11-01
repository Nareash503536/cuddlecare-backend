package com.example.CuddleCare.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "food_ingredient")
public class FoodIngredient implements Serializable {

    @EmbeddedId
    FoodIngredientKey foodIngredientID;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("foodFeedingID")
    @JoinColumn(name = "food_id", referencedColumnName = "food_id")

   FoodFeeding foodFeeding;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ingredientID")
    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id")

   Ingredient ingredient;

    @Basic
    @Column(name = "quantity")
    private String quantity;

    @Basic
    @Column(name = "units")
    private String units;
}

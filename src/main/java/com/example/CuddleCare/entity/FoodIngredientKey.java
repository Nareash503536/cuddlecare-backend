package com.example.CuddleCare.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;



@Getter
@Setter
@Embeddable

public class FoodIngredientKey implements Serializable {


    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id")

    private Long ingredientID;

    @JoinColumn(name = "food_id", referencedColumnName = "food_id")
    private Long foodFeedingID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodIngredientKey that = (FoodIngredientKey) o;
        return Objects.equals(ingredientID, that.ingredientID) &&
                Objects.equals(foodFeedingID, that.foodFeedingID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientID, foodFeedingID);
    }

}

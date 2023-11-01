package com.example.CuddleCare.dto;

import com.example.CuddleCare.entity.FoodFeeding;
import com.example.CuddleCare.entity.FoodIngredientKey;
import com.example.CuddleCare.entity.Ingredient;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter

public class FoodIngredientDTO {

    FoodIngredientKey foodIngredientID;

    private FoodfeedingDTO foodfeedingDTO;

    private IngredientsDTO ingredientsDTO;

    private String quantity;

    private String units;

}

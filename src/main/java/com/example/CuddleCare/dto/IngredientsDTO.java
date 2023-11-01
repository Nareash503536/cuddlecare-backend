package com.example.CuddleCare.dto;

import com.example.CuddleCare.entity.FoodIngredient;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

public class IngredientsDTO {


    private Long ingredientID;

    private String name;

    private String category;

    private String image;

}

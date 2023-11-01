package com.example.CuddleCare.dto;

import com.example.CuddleCare.entity.Baby;
import com.example.CuddleCare.entity.FoodIngredient;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Set;

@Getter
@Setter

public class FoodfeedingDTO {


    private Long foodFeedingID;

    private String feedingTime;

    private String mixtureName;

    private Date feedingDate;

    private String reaction;

    private String additionalNotes;

//    private Set<FoodIngredient> foodIngredients;
//    private Baby baby;

}

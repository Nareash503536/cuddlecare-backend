package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.FoodIngredientDTO;
import com.example.CuddleCare.dto.FoodfeedingDTO;
import com.example.CuddleCare.entity.FoodFeeding;
import com.example.CuddleCare.entity.FoodIngredient;

import java.util.List;

public interface FoodIngredientsService {

    FoodIngredientDTO createfoodingredient(FoodIngredientDTO foodIngredientDTO);

    List<FoodIngredient> getAllfoodingredients();




}

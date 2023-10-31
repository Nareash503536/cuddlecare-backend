package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.FoodfeedingDTO;
import com.example.CuddleCare.dto.IngredientsDTO;
import com.example.CuddleCare.entity.FoodFeeding;
import com.example.CuddleCare.entity.Ingredient;

import java.util.List;

public interface IngredientsService {

    IngredientsDTO createingredients(IngredientsDTO ingredientsDTO);

    List<Ingredient> getAllingredients();




}

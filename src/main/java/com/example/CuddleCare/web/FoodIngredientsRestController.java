package com.example.CuddleCare.web;


import com.example.CuddleCare.dto.FoodIngredientDTO;
import com.example.CuddleCare.dto.IngredientsDTO;
import com.example.CuddleCare.entity.FoodIngredient;
import com.example.CuddleCare.entity.Ingredient;
import com.example.CuddleCare.service.FoodIngredientsService;
import com.example.CuddleCare.service.IngredientsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class FoodIngredientsRestController {
    private FoodIngredientsService foodIngredientsService;

    public FoodIngredientsRestController(FoodIngredientsService foodIngredientsService) {
        this.foodIngredientsService = foodIngredientsService;
    }
    @PostMapping("/foodingredient/add")
    public FoodIngredientDTO saveFoodIngredients(@RequestBody FoodIngredientDTO foodIngredientDTO){

        return foodIngredientsService.createfoodingredient(foodIngredientDTO);

    }

    @GetMapping("/foodingredients/all")
    public ResponseEntity<List<FoodIngredient>> getAllfoodingredients(){
        List<FoodIngredient> foodIngredients = foodIngredientsService.getAllfoodingredients();
        return new ResponseEntity<>(foodIngredients, HttpStatus.OK);
    }




}

package com.example.CuddleCare.web;


import com.example.CuddleCare.dto.IngredientsDTO;

import com.example.CuddleCare.entity.Ingredient;

import com.example.CuddleCare.service.IngredientsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class IngredientsRestController {
    private IngredientsService ingredientsService;

    public IngredientsRestController( IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }
    @PostMapping("/ingredient/add")
    public IngredientsDTO saveingredients(@RequestBody IngredientsDTO ingredientsDTO){

        return ingredientsService.createingredients(ingredientsDTO);

    }

    @GetMapping("/ingredients/all")
    public ResponseEntity<List<Ingredient>> getAllingredients(){
        List<Ingredient> ingredients = ingredientsService.getAllingredients();
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }




}

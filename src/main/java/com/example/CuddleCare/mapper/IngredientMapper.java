package com.example.CuddleCare.mapper;


import com.example.CuddleCare.dto.IngredientsDTO;
import com.example.CuddleCare.entity.Ingredient;
import org.springframework.stereotype.Service;

@Service
public class IngredientMapper {

    public Ingredient FromIngredientsDTO(IngredientsDTO ingredientsDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setCategory(ingredientsDto.getCategory());
        ingredient.setName(ingredientsDto.getName());
        ingredient.setImage(ingredientsDto.getImage());
//        ingredient.setIngredientID(ingredientsDto.getIngredientID());

        return ingredient;
    }

    public IngredientsDTO FromIngredient(Ingredient ingredient) {
        IngredientsDTO ingredientDto = new IngredientsDTO();

        ingredientDto.setCategory(ingredient.getCategory());
        ingredientDto.setImage(ingredient.getImage());
        ingredientDto.setName(ingredient.getName());
//        ingredientDto.setIngredientID(ingredient.getIngredientID());
        return ingredientDto;
    }
}
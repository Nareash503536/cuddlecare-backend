package com.example.CuddleCare.mapper;


import com.example.CuddleCare.dto.FoodIngredientDTO;
import com.example.CuddleCare.entity.FoodIngredient;
import com.example.CuddleCare.entity.FoodIngredientKey;
import org.springframework.stereotype.Service;

@Service
public class FoodIngredientMapper {
    private IngredientMapper ingredientMapper;
    private FoodFeedingMapper foodFeedingMapper;


    public FoodIngredientMapper(IngredientMapper ingredientMapper, FoodFeedingMapper foodFeedingMapper) {
        this.ingredientMapper = ingredientMapper;
        this.foodFeedingMapper = foodFeedingMapper;


    }
    public FoodIngredient FromFoodIngredientDTO(FoodIngredientDTO foodingredientDto) {
        FoodIngredient foodIngredient = new FoodIngredient();
        foodIngredient.setIngredient(ingredientMapper.FromIngredientsDTO(foodingredientDto.getIngredientsDTO()));
        foodIngredient.setQuantity(foodingredientDto.getQuantity());
        foodIngredient.setFoodFeeding(foodFeedingMapper.FromFoodfeedingDTO(foodingredientDto.getFoodfeedingDTO()));
        foodIngredient.setUnits(foodingredientDto.getUnits());
        FoodIngredientKey foodIngredientKey = new FoodIngredientKey();
        foodIngredientKey.setIngredientID(foodingredientDto.getIngredientsDTO().getIngredientID());
        foodIngredientKey.setFoodFeedingID(foodingredientDto.getFoodfeedingDTO().getFoodFeedingID());

        foodIngredient.setFoodIngredientID(foodIngredientKey);

        return foodIngredient;
    }

    public FoodIngredientDTO FromFoodIngredient(FoodIngredient foodIngredient) {
        FoodIngredientDTO foodingredientDto = new FoodIngredientDTO();
        foodingredientDto.setIngredientsDTO(ingredientMapper.FromIngredient(foodIngredient.getIngredient()));
        foodingredientDto.setQuantity(foodIngredient.getQuantity());
        foodingredientDto.setFoodfeedingDTO(foodFeedingMapper.FromFoodFeeding(foodIngredient.getFoodFeeding()));
        foodingredientDto.setUnits(foodIngredient.getUnits());
        FoodIngredientKey foodIngredientKey = new FoodIngredientKey();
        foodIngredientKey.setIngredientID(ingredientMapper.FromIngredient(foodIngredient.getIngredient()).getIngredientID());
        foodIngredientKey.setFoodFeedingID(foodFeedingMapper.FromFoodFeeding(foodIngredient.getFoodFeeding()).getFoodFeedingID());

        foodingredientDto.setFoodIngredientID(foodIngredientKey);
        return foodingredientDto;
    }
}
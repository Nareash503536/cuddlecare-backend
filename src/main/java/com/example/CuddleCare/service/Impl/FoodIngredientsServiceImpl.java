// new interface ExpenseService

package com.example.CuddleCare.service.Impl;



import com.example.CuddleCare.dao.FoodFeedingDao;
import com.example.CuddleCare.dao.FoodIngredientDao;
import com.example.CuddleCare.dao.IngredientDao;
import com.example.CuddleCare.dto.FoodIngredientDTO;

import com.example.CuddleCare.dto.FoodfeedingDTO;
import com.example.CuddleCare.entity.FoodFeeding;
import com.example.CuddleCare.entity.FoodIngredient;

import com.example.CuddleCare.entity.Ingredient;
import com.example.CuddleCare.mapper.FoodIngredientMapper;
import com.example.CuddleCare.service.FoodFeedingService;
import com.example.CuddleCare.service.FoodIngredientsService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class FoodIngredientsServiceImpl implements FoodIngredientsService {

    private FoodIngredientMapper foodIngredientMapper;
    private FoodIngredientDao foodingredientDao;

    private IngredientDao ingredientDao;

    private FoodFeedingDao foodFeedingDao;

    private  FoodFeedingService foodFeedingService;

    public FoodIngredientsServiceImpl(IngredientDao ingredientDao, FoodFeedingService foodFeedingService,FoodFeedingDao foodFeedingDao, FoodIngredientDao foodingredientDao, FoodIngredientMapper foodIngredientMapper) {
        this.foodingredientDao = foodingredientDao;
        this.foodIngredientMapper = foodIngredientMapper;
        this.foodFeedingDao = foodFeedingDao;
        this.ingredientDao = ingredientDao;
        this.foodFeedingService = foodFeedingService;
    }


    @Override
    public FoodIngredientDTO createfoodingredient(FoodIngredientDTO foodIngredientDTO) {
        FoodIngredient foodIngredient = foodIngredientMapper.FromFoodIngredientDTO(foodIngredientDTO);
//        FoodfeedingDTO foodFeedingdto = foodFeedingService.createfoodFeeding(foodIngredientDTO.getFoodfeedingDTO());
//        FoodFeeding foodFeeding = foodFeedingDao.findById(foodFeedingdto.getFoodFeedingID()).orElseThrow(() -> new EntityNotFoundException("FoodFeeding with ID " + foodFeedingdto.getFoodFeedingID() + " Not Found"));

// Try to find the FoodFeeding entity by its ID
        FoodFeeding foodFeeding = foodFeedingDao.findById(foodIngredientDTO.getFoodfeedingDTO().getFoodFeedingID()).orElse(null);
        if (foodFeeding == null) {
            // FoodFeeding with the specified ID doesn't exist, so create a new one
            FoodfeedingDTO foodFeedingDTo = foodFeedingService.createfoodFeeding(foodIngredientDTO.getFoodfeedingDTO());
            foodFeeding = foodFeedingDao.findById(foodFeedingDTo.getFoodFeedingID()).orElseThrow(() -> new EntityNotFoundException("FoodFeeding with ID " + foodFeedingDTo.getFoodFeedingID() + " Not Found"));
        }

        foodIngredient.setFoodFeeding(foodFeeding);
        Ingredient ingredient = ingredientDao.findById(foodIngredientDTO.getIngredientsDTO().getIngredientID()).orElseThrow(() -> new EntityNotFoundException("Ingredient with ID " + foodIngredientDTO.getIngredientsDTO().getIngredientID() + " Not Found"));
        foodIngredient.setIngredient(ingredient);
        FoodIngredient savedFoodIngredient= foodingredientDao.save(foodIngredient);
        return foodIngredientMapper.FromFoodIngredient(savedFoodIngredient);

    }

    @Override
    public List<FoodIngredient> getAllfoodingredients() {
        return foodingredientDao.findAll();
    }


}




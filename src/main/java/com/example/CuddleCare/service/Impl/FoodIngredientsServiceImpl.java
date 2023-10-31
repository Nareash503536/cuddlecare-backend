// new interface ExpenseService

package com.example.CuddleCare.service.Impl;



import com.example.CuddleCare.dao.FoodFeedingDao;
import com.example.CuddleCare.dao.FoodIngredientDao;
import com.example.CuddleCare.dao.IngredientDao;
import com.example.CuddleCare.dto.FoodIngredientDTO;

import com.example.CuddleCare.entity.FoodFeeding;
import com.example.CuddleCare.entity.FoodIngredient;

import com.example.CuddleCare.entity.Ingredient;
import com.example.CuddleCare.mapper.FoodIngredientMapper;
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

    public FoodIngredientsServiceImpl(IngredientDao ingredientDao,FoodFeedingDao foodFeedingDao,FoodIngredientDao foodingredientDao, FoodIngredientMapper foodIngredientMapper) {
        this.foodingredientDao = foodingredientDao;
        this.foodIngredientMapper = foodIngredientMapper;
        this.foodFeedingDao = foodFeedingDao;
        this.ingredientDao = ingredientDao;
    }


    @Override
    public FoodIngredientDTO createfoodingredient(FoodIngredientDTO foodIngredientDTO) {
        FoodIngredient foodIngredient = foodIngredientMapper.FromFoodIngredientDTO(foodIngredientDTO);
        FoodFeeding foodFeeding = foodFeedingDao.findById(foodIngredientDTO.getFoodfeedingDTO().getFoodFeedingID()).orElseThrow(() -> new EntityNotFoundException("FoodFeeding with ID " + foodIngredientDTO.getFoodfeedingDTO().getFoodFeedingID() + " Not Found"));
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




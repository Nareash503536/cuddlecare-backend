// new interface ExpenseService

package com.example.CuddleCare.service.Impl;



import com.example.CuddleCare.dao.IngredientDao;
import com.example.CuddleCare.dto.IngredientsDTO;
import com.example.CuddleCare.entity.Ingredient;
import com.example.CuddleCare.mapper.IngredientMapper;
import com.example.CuddleCare.service.IngredientsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class IngredientsServiceImpl implements IngredientsService {

    private IngredientMapper ingredientMapper;
    private IngredientDao ingredientDao;
    public IngredientsServiceImpl( IngredientDao ingredientDao, IngredientMapper ingredientMapper) {
        this.ingredientDao = ingredientDao;
        this.ingredientMapper = ingredientMapper;
    }


    @Override
    public IngredientsDTO createingredients(IngredientsDTO ingredientsDTO) {
        Ingredient foodFeeding = ingredientMapper.FromIngredientsDTO(ingredientsDTO);
        Ingredient savedIngredient= ingredientDao.save(foodFeeding);
        return ingredientMapper.FromIngredient(savedIngredient);

    }

    @Override
    public List<Ingredient> getAllingredients() {
        return ingredientDao.findAll();
    }


}




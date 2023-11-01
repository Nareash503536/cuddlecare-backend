package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.FoodIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodIngredientDao extends JpaRepository<FoodIngredient, Long> {
}

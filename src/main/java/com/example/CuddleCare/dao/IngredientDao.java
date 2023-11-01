package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDao extends JpaRepository<Ingredient, Long> {
}

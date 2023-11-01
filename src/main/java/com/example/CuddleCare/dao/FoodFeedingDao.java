package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.BreastFeeding;
import com.example.CuddleCare.entity.FoodFeeding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface FoodFeedingDao extends JpaRepository<FoodFeeding, Long> {

    @Query(value = "SELECT foodfeeding.*,ingredient.*,food_ingredient.quantity,food_ingredient.units, foodfeeding.food_id AS foodfeeding_id, " +
            "       food_ingredient.food_id AS foodingredient_food_id, " +
            "       food_ingredient.ingredient_id AS foodingredient_ingredient_id, " +
            "       ingredient.ingredient_id AS ing_ingredient_id " +
            "FROM foodfeeding " +
            "JOIN food_ingredient ON foodfeeding.food_id = food_ingredient.food_id " +
            "JOIN ingredient ON food_ingredient.ingredient_id = ingredient.ingredient_id " +
            "WHERE feedingdate > :threeDaysAgo", nativeQuery = true)

    public List<Map<String, Object>> AllFeedingsByDate(@Param("threeDaysAgo") LocalDate threeDaysAgo);
}

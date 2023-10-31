package com.example.CuddleCare.mapper;


import com.example.CuddleCare.dto.FoodfeedingDTO;
import com.example.CuddleCare.entity.FoodFeeding;
import org.springframework.stereotype.Service;

@Service
public class FoodFeedingMapper {

    public FoodFeeding FromFoodfeedingDTO(FoodfeedingDTO foodfeedingDTO) {
        FoodFeeding foodFeeding = new FoodFeeding();
        foodFeeding.setFeedingTime(foodfeedingDTO.getFeedingTime());
        foodFeeding.setFeedingDate(foodfeedingDTO.getFeedingDate());
        foodFeeding.setAdditionalNotes(foodfeedingDTO.getAdditionalNotes());
        foodFeeding.setReaction(foodfeedingDTO.getReaction());
        foodFeeding.setMixtureName(foodfeedingDTO.getMixtureName());
//        foodFeeding.setFoodIngredients(foodfeedingDTO.getFoodIngredients());
//        foodFeeding.setBaby(foodfeedingDTO.getBaby());

        return foodFeeding;
    }

    public FoodfeedingDTO FromFoodFeeding(FoodFeeding foodFeeding) {
        FoodfeedingDTO foodfeedingDto = new FoodfeedingDTO();

        foodfeedingDto.setFeedingTime(foodFeeding.getFeedingTime());
        foodfeedingDto.setFeedingDate(foodFeeding.getFeedingDate());
        foodfeedingDto.setAdditionalNotes(foodFeeding.getAdditionalNotes());
        foodfeedingDto.setReaction(foodFeeding.getReaction());
        foodfeedingDto.setMixtureName(foodFeeding.getMixtureName());
//        foodfeedingDto.setFoodIngredients(foodFeeding.getFoodIngredients());
        return foodfeedingDto;
    }
}
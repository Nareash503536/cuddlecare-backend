package com.example.CuddleCare.web;
import com.example.CuddleCare.dto.FoodfeedingDTO;
import com.example.CuddleCare.entity.FoodFeeding;
import com.example.CuddleCare.service.FoodFeedingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class FoodFeedRestController {
    private FoodFeedingService foodFeedingService;

    public FoodFeedRestController(FoodFeedingService foodFeedingService) {
        this.foodFeedingService = foodFeedingService;
    }
    @PostMapping("/foodFeeding/add")
    public FoodfeedingDTO saveFoodFeeding(@RequestBody FoodfeedingDTO foodfeedingDTO){

        return foodFeedingService.createfoodFeeding(foodfeedingDTO);

    }

    @GetMapping("/foodFeeding/all")
    public ResponseEntity<List<FoodFeeding>> getAllfoodFeeding(){
        List<FoodFeeding> foodFeedings = foodFeedingService.getAllfoodfeeding();
        return new ResponseEntity<>(foodFeedings, HttpStatus.OK);
    }




}

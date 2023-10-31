package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.BreastFeedingDTO;
import com.example.CuddleCare.dto.FoodfeedingDTO;
import com.example.CuddleCare.entity.BreastFeeding;
import com.example.CuddleCare.entity.FoodFeeding;

import java.util.List;

public interface FoodFeedingService {

    FoodfeedingDTO createfoodFeeding(FoodfeedingDTO foodfeedingDTO);

    List<FoodFeeding> getAllfoodfeeding();




}

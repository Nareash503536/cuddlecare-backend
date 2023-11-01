package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.BottleFeedingDTO;
import com.example.CuddleCare.entity.BottleFeeding;

import java.util.List;
import java.util.Optional;

public interface BottleFeedingService {

    BottleFeedingDTO createBottleFeeding(BottleFeedingDTO bottleFeedingDTO);

    List<BottleFeeding> getFeedingDetails();

    List<BottleFeeding> getlastthreeBFeeding();




}

package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.BreastFeedingDTO;
import com.example.CuddleCare.entity.BreastFeeding;


import java.util.List;

public interface BFeedService {

    BreastFeedingDTO createBfeeding(BreastFeedingDTO breastFeedingDTO);

    List<BreastFeeding> getAllBFeeding();
  List<BreastFeeding> getlastthreeBFeeding();




}

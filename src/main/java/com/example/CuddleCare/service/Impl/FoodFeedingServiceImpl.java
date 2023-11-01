// new interface ExpenseService

package com.example.CuddleCare.service.Impl;


import com.example.CuddleCare.dao.FoodFeedingDao;
import com.example.CuddleCare.dto.FoodfeedingDTO;
import com.example.CuddleCare.entity.FoodFeeding;
import com.example.CuddleCare.mapper.FoodFeedingMapper;
import com.example.CuddleCare.service.FoodFeedingService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class FoodFeedingServiceImpl implements FoodFeedingService {

    private FoodFeedingMapper foodFeedingmapper;
    private FoodFeedingDao foodFeedingDao;
    public FoodFeedingServiceImpl(FoodFeedingDao foodFeedingDao, FoodFeedingMapper foodFeedingmapper) {
        this.foodFeedingDao = foodFeedingDao;
        this.foodFeedingmapper = foodFeedingmapper;
    }


    @Override
    public FoodfeedingDTO createfoodFeeding(FoodfeedingDTO foodfeedingDTO) {
        FoodFeeding foodFeeding = foodFeedingmapper.FromFoodfeedingDTO(foodfeedingDTO);
        FoodFeeding savedFoodFeeding= foodFeedingDao.save(foodFeeding);
        return foodFeedingmapper.FromFoodFeeding(savedFoodFeeding);

    }

    @Override
    public List<FoodFeeding> getAllfoodfeeding() {
        return foodFeedingDao.findAll();
    }


}




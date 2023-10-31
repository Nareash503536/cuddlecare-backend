package com.example.CuddleCare.mapper;


import com.example.CuddleCare.dto.BottleFeedingDTO;

import com.example.CuddleCare.entity.BottleFeeding;
import org.springframework.stereotype.Service;

@Service
public class BottleFeedingMapper {

    public BottleFeeding FromBottleFeedingDTO(BottleFeedingDTO bottlefeedingDto) {
        BottleFeeding bottlefeeding = new BottleFeeding();

        bottlefeeding.setFeedingTime(bottlefeedingDto.getFeedingTime());
        bottlefeeding.setFeedingDate(bottlefeedingDto.getFeedingDate());
        bottlefeeding.setFeedingType(bottlefeedingDto.getFeedingType());
        bottlefeeding.setQuantity(bottlefeedingDto.getQuantity());
//        bottlefeeding.setBaby(bottlefeedingDto.getBaby());
//        bottlefeeding.setBaby(bottlefeedingDto.getBaby());
        return bottlefeeding;
    }

    public BottleFeedingDTO FromBottleFeeding(BottleFeeding bottlefeeding) {
        BottleFeedingDTO bottlefeedingDto = new BottleFeedingDTO();

        bottlefeedingDto.setFeedingTime(bottlefeeding.getFeedingTime());
        bottlefeedingDto.setFeedingType(bottlefeeding.getFeedingType());
        bottlefeedingDto.setFeedingDate(bottlefeeding.getFeedingDate());
        bottlefeedingDto.setQuantity(bottlefeeding.getQuantity());
//        bottlefeedingDto.setBaby(bottlefeeding.getBaby());
//        bottlefeedingDto.setBaby(bottlefeeding.getBaby());
        return bottlefeedingDto;
    }
}
package com.example.CuddleCare.mapper;


import com.example.CuddleCare.dto.BreastFeedingDTO;
import com.example.CuddleCare.dto.BreastFeedingDTO;
import com.example.CuddleCare.entity.BreastFeeding;
import com.example.CuddleCare.entity.BreastFeeding;
import org.springframework.stereotype.Service;

@Service
public class BreastFeedingMapper {

    public BreastFeeding FromBreastFeedingDTO(BreastFeedingDTO breastFeedingDto) {
        BreastFeeding breastFeeding = new BreastFeeding();

        breastFeeding.setFeedingDuration(breastFeedingDto.getFeedingDuration());
        breastFeeding.setStarttime(breastFeedingDto.getStarttime());
        breastFeeding.setEndtime(breastFeedingDto.getEndtime());
        breastFeeding.setFeedingDate(breastFeedingDto.getFeedingDate());
        breastFeeding.setSide(breastFeedingDto.getSide());
//        breastFeeding.setBaby(breastFeedingDto.getBaby());
        return breastFeeding;
    }

    public BreastFeedingDTO FromBreastFeeding(BreastFeeding breastFeeding) {
        BreastFeedingDTO breastFeedingDto = new BreastFeedingDTO();

        breastFeedingDto.setFeedingDuration(breastFeeding.getFeedingDuration());
        breastFeedingDto.setStarttime(breastFeeding.getStarttime());
        breastFeedingDto.setEndtime(breastFeeding.getEndtime());
        breastFeedingDto.setFeedingDate(breastFeeding.getFeedingDate());
        breastFeedingDto.setSide(breastFeeding.getSide());
//        breastFeedingDto.setBaby(breastFeeding.getBaby());
        return breastFeedingDto;
    }
}
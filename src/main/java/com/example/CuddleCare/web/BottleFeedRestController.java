package com.example.CuddleCare.web;

import com.example.CuddleCare.dto.BottleFeedingDTO;
import com.example.CuddleCare.dto.CaregiverDTO;
import com.example.CuddleCare.entity.BottleFeeding;
import com.example.CuddleCare.entity.BreastFeeding;
import com.example.CuddleCare.service.BottleFeedingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class BottleFeedRestController {
    private BottleFeedingService bottlefeedservice;

    public BottleFeedRestController(BottleFeedingService bottlefeedservice) {
        this.bottlefeedservice = bottlefeedservice;
    }

    @PostMapping("/bottlefeeding/add")
    public BottleFeedingDTO saveBreastFeeding(@RequestBody BottleFeedingDTO bottlefeedingDto){

       return bottlefeedservice.createBottleFeeding(bottlefeedingDto);

    }
    @GetMapping("/bottlefeeding/all")
    public ResponseEntity <List<BottleFeeding>> getBottleFeeddetails(){
        List<BottleFeeding> bottleFeedings = bottlefeedservice.getFeedingDetails();
        return new ResponseEntity<>(bottleFeedings, HttpStatus.OK);
    }

    @GetMapping("/bottlefeeding/allDate")
    public ResponseEntity<List<BottleFeeding>> getfeedingsByDate(){
        List<BottleFeeding> bottleFeedings = bottlefeedservice.getlastthreeBFeeding();
        return new ResponseEntity<>(bottleFeedings, HttpStatus.OK);
    }



}

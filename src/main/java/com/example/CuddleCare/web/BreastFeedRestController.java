package com.example.CuddleCare.web;

import com.example.CuddleCare.dto.BreastFeedingDTO;
import com.example.CuddleCare.dto.BudgetDTO;
import com.example.CuddleCare.entity.BreastFeeding;
import com.example.CuddleCare.entity.Budget;
import com.example.CuddleCare.service.BFeedService;
import com.example.CuddleCare.service.BudgetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;


@RestController
public class BreastFeedRestController {
    private BFeedService bFeedService;

    public BreastFeedRestController(BFeedService bFeedService) {
        this.bFeedService = bFeedService;
    }
    @PostMapping("/BreastFeeding/add")
    public BreastFeedingDTO saveBreastFeeding(@RequestBody BreastFeedingDTO breastFeedingDTO){

       return bFeedService.createBfeeding(breastFeedingDTO);

    }
    @GetMapping("/BreastFeeding/all")
    public ResponseEntity<List<BreastFeeding>> getAllBfeeding(){
        List<BreastFeeding> breastFeedings = bFeedService.getAllBFeeding();
        return new ResponseEntity<>(breastFeedings, HttpStatus.OK);
    }




}

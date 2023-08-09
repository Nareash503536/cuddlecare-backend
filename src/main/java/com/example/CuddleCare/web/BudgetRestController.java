package com.example.CuddleCare.web;

import com.example.CuddleCare.dto.BudgetDTO;
import com.example.CuddleCare.entity.Budget;
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
public class BudgetRestController {
    private BudgetService budgetService;

    public BudgetRestController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }
    @PostMapping("/budget")
    public BudgetDTO saveBudget(@RequestBody BudgetDTO budgetDTO){

       return budgetService.createBudget(budgetDTO);

    }
    @GetMapping("/budget/all")
    public ResponseEntity<List<Budget>> getAllBudgets(){
        List<Budget> budgets = budgetService.getAllBudget();
        return new ResponseEntity<>(budgets, HttpStatus.OK);
    }

    @GetMapping("/budget/endDate")
    public ResponseEntity<Date> getEndDate(){
        Date endDate = budgetService.getEndDate();
        return new ResponseEntity<>(endDate, HttpStatus.OK);
    }
//    @GetMapping("/budgets/totalIncome")
//    public ResponseEntity<Double> getTotalIncome(){
//        Double totalIncome = budgetService.getTotalIncome();
//        return new ResponseEntity<>(totalIncome, HttpStatus.OK);
//    }
    @GetMapping("/budget/totalBudget")
    public ResponseEntity<Object> getTotalBudget(){
        try {
            BudgetDTO totalBudget = budgetService.getTotalBudget();
            return ResponseEntity.ok(totalBudget);
        } catch (EntityNotFoundException ex) {
            // Handle the case when no budget is available
            String errorMessage = "No budget available";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } catch (Exception ex) {
            // Handle other exceptions or unexpected errors
            String errorMessage = "An error occurred while fetching the total budget";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }


}

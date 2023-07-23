package com.example.CuddleCare.web;
import com.example.CuddleCare.entity.Expense;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.CuddleCare.service.ExpenseService;

import java.util.List;


@RestController
public class ExpenseRestController {
    private ExpenseService expenseService;

    public ExpenseRestController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    @PostMapping("/expenses")
    public boolean createExpense(
            String expenseName,
            String notes,
            Double amount
    ){
        expenseService.createExpense(expenseName, notes, amount);
        return true;
    }
    @GetMapping("/expenses/all")
    public ResponseEntity<List<Expense>> getAllExpenses(){
        List<Expense> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }
}

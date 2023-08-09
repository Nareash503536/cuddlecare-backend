package com.example.CuddleCare.web;
import com.example.CuddleCare.dto.BudgetDTO;
import com.example.CuddleCare.dto.ExpenseDTO;
import com.example.CuddleCare.entity.Expense;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.CuddleCare.service.ExpenseService;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;


@RestController
public class ExpenseRestController {
    private ExpenseService expenseService;

    public ExpenseRestController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    @PostMapping("/expenses")
    public ExpenseDTO saveExpense(@RequestBody ExpenseDTO expenseDTO){

       return expenseService.createExpense(expenseDTO);

    }
    @GetMapping("/expenses/all")
    public ResponseEntity<List<Expense>> getAllExpenses(){
        List<Expense> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @DeleteMapping("/expenses/delete/{expenseID}")
    public void deleteExpense(@PathVariable Long expenseID){
        expenseService.deleteExpense(expenseID);
    }
    @GetMapping("/expenses/firstDate")
    public ResponseEntity<Date> getFirstDate(){
        Date firstdate = expenseService.getFirstdate();
        return new ResponseEntity<>(firstdate, HttpStatus.OK);
    }
//    @GetMapping("/expenses/totalIncome")
//    public ResponseEntity<Double> getTotalIncome(){
//        Double totalIncome = expenseService.getTotalIncome();
//        return new ResponseEntity<>(totalIncome, HttpStatus.OK);
//    }
    @GetMapping("/expenses/totalExpense")
    public ResponseEntity<Object> getTotalExpense(){
        try {
            Double totalExpense = expenseService.getTotalExpense();
            return ResponseEntity.ok(totalExpense);
        } catch (EntityNotFoundException ex) {
            // Handle the case when no budget is available
            String errorMessage = "No budget available";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }

    }
    @PutMapping("/expenses/edit/{expenseID}")
    public ExpenseDTO updatedExpense(@RequestBody ExpenseDTO expenseDTO,@PathVariable Long expenseID){
        expenseDTO.setExpenseID(expenseID);
        return expenseService.updateExpense(expenseDTO);
    }


}

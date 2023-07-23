// new interface ExpenseService

package com.example.CuddleCare.service;

import com.example.CuddleCare.entity.Expense;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ExpenseService {


    Expense createExpense(
            String expenseName,
            String notes,
            Double amount
    );

    List<Expense> getAllExpenses();

}




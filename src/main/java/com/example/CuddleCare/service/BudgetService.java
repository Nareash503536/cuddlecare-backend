package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.BudgetDTO;
import com.example.CuddleCare.dto.ExpenseDTO;
import com.example.CuddleCare.entity.Budget;
import com.example.CuddleCare.entity.Expense;

import java.util.Date;
import java.util.List;

public interface BudgetService {

    BudgetDTO createBudget(BudgetDTO budgetDTO);

    List<Budget> getAllBudget();
    BudgetDTO getTotalBudget();
    Date getEndDate();



}

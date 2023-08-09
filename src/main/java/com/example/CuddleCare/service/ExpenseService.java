// new interface ExpenseService

package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.ExpenseDTO;
import com.example.CuddleCare.entity.Expense;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface ExpenseService {


    ExpenseDTO createExpense(ExpenseDTO expenseDTO);

    List<Expense> getAllExpenses();
//    Double getTotalIncome();
    Double getTotalExpense();

    Date getFirstdate();

    void deleteExpense(Long expenseID);

    ExpenseDTO updateExpense(ExpenseDTO expenseDTO);
}




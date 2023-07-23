package com.example.CuddleCare.mapper;


import com.example.CuddleCare.dto.ExpenseDTO;
import com.example.CuddleCare.entity.Expense;
import org.springframework.stereotype.Service;

@Service
public class ExpenseMapper {

    public Expense FromExpenseDto(ExpenseDTO expenseDto) {
        Expense expense = new Expense();
        expense.setExpenseName(expenseDto.getExpenseName());
        expense.setNotes(expenseDto.getNotes());
        expense.setAmount(expenseDto.getAmount());
        return expense;
    }

    public ExpenseDTO FromExpense(Expense expense) {
        ExpenseDTO expenseDto = new ExpenseDTO();
        expenseDto.setExpenseName(expense.getExpenseName());
        expenseDto.setNotes(expense.getNotes());
        expenseDto.setAmount(expense.getAmount());
        return expenseDto;
    }
}
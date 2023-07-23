// new interface ExpenseService

package com.example.CuddleCare.service.Impl;
import com.example.CuddleCare.dao.ExpenseDao;
import com.example.CuddleCare.service.ExpenseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import com.example.CuddleCare.entity.Expense;

import java.util.List;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseDao expenseDao;
    public ExpenseServiceImpl(ExpenseDao expenseDao) {
        this.expenseDao = expenseDao;
    }


    @Override
    public Expense createExpense(String expenseName, String notes, Double amount) {

        return expenseDao.save(new Expense(expenseName, notes, amount));

    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseDao.findAll();
    }

}




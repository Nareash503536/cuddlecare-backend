// new interface ExpenseService

package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.BudgetDao;
import com.example.CuddleCare.dto.BudgetDTO;
import com.example.CuddleCare.entity.Budget;
import com.example.CuddleCare.mapper.BudgetMapper;
import com.example.CuddleCare.service.BudgetService;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class BudgetServiceImpl implements BudgetService {

    private BudgetMapper budgetMapper;
    private BudgetDao budgetDao;
    public BudgetServiceImpl(BudgetDao budgetDao, BudgetMapper Budgetmapper) {
        this.budgetDao = budgetDao;
        this.budgetMapper = Budgetmapper;
    }


    @Override
    public BudgetDTO createBudget(BudgetDTO budgetDTO) {
        Budget budget = budgetMapper.FromBudgetDTO(budgetDTO);
        Budget savedBudget = budgetDao.save(budget);
        return budgetMapper.FromBudget(savedBudget);

    }

    @Override
    public List<Budget> getAllBudget() {
        return budgetDao.findAll();
    }

//    @Override
//    public  Double getTotalIncome() {
//        return budgetDao.TotalIncome();
//    }

    @Override
    public  BudgetDTO getTotalBudget() {
        Budget budget=  budgetDao.TotalBudget().orElseThrow(() -> new EntityNotFoundException("No budget available"));
        return budgetMapper.FromBudget(budget);
    }
    @Override
    public Date getEndDate() {
        return budgetDao.getLastDate();
    }
}




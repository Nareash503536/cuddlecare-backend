package com.example.CuddleCare.mapper;


import com.example.CuddleCare.dto.BudgetDTO;
import com.example.CuddleCare.entity.Budget;
import org.springframework.stereotype.Service;

@Service
public class BudgetMapper {

    public Budget FromBudgetDTO(BudgetDTO budgetDto) {
        Budget budget = new Budget();
        budget.setBudgetName(budgetDto.getBudgetName());
        budget.setAmount(budgetDto.getAmount());
        budget.setStartdate(budgetDto.getStartdate());
        budget.setEnddate(budgetDto.getEnddate());

        return budget;
    }

    public BudgetDTO FromBudget(Budget budget) {
        BudgetDTO budgetDto = new BudgetDTO();
        budgetDto.setBudgetName(budget.getBudgetName());
        budgetDto.setAmount(budget.getAmount());
        budgetDto.setStartdate(budget.getStartdate());
        budgetDto.setEnddate(budget.getEnddate());
        return budgetDto;
    }
}
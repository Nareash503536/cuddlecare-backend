package com.example.CuddleCare.dao;// new class BabyDao

import com.example.CuddleCare.dto.BudgetDTO;
import com.example.CuddleCare.entity.Budget;
import com.example.CuddleCare.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface BudgetDao extends JpaRepository<Budget, Long>{
    //if amount returns null COALESCE will return 0, it is used to avoid null pointer exception by returning the first not null argument in the list

    @Query(value = "SELECT * FROM budget  where start_date <= CURRENT_DATE and end_date >= CURRENT_DATE order by start_date ASC LIMIT 1", nativeQuery = true)
    public Optional<Budget> TotalBudget();
    @Query(value = "SELECT MAX(end_date) FROM budget ", nativeQuery = true)

    public Date getLastDate();


}


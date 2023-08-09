package com.example.CuddleCare.dao;// new class BabyDao

import com.example.CuddleCare.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ExpenseDao extends JpaRepository<Expense, Long>{
    //if amount returns null COALESCE will return 0, it is used to avoid null pointer exception by returning the first not null argument in the list

//    @Query(value = "SELECT COALESCE(SUM(amount),0) FROM expense where expense_category ='Income' ", nativeQuery = true)
//    public Double TotalIncome();
    @Query(value = "SELECT COALESCE(SUM(amount),0) FROM expense ", nativeQuery = true)
    public Double TotalExpense();

    @Query(value = "SELECT MIN(date) FROM expense ", nativeQuery = true)

    public Date getfirstDate();
}


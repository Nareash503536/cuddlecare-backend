package com.example.CuddleCare.dao;// new class BabyDao

import com.example.CuddleCare.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseDao extends JpaRepository<Expense, Long>{
}

// new class ExpenseDTO

package com.example.CuddleCare.dto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
public class ExpenseDTO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseID;

    private String expenseName;

    private String notes;

    private Double amount;




}



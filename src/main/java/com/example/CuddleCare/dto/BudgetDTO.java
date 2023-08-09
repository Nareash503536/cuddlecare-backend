// new class ExpenseDTO

package com.example.CuddleCare.dto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
public class BudgetDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long budgetID;

    private String budgetName;

    private Double amount;

    private Date startdate;

    private Date enddate;




}



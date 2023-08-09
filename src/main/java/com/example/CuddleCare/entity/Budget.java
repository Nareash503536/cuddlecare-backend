package com.example.CuddleCare.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "budget")
public class Budget {
    public Budget(String budgetName, Date startdate,Date enddate, Double amount) {
        this.budgetID = budgetID;
        this.budgetName = budgetName;
        this.amount = amount;
        this.startdate = startdate;
        this.enddate = enddate;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "budget_ID", nullable = false)
    private Long budgetID;

    @Basic
    @Column(name = "budget_name", nullable = false)
    private String budgetName;




    @Basic
    @Column(name = "start_date")
    private Date startdate;

    @Basic
    @Column(name = "end_date")
    private Date enddate;
    @Basic
    @Column(name = "amount")
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id", referencedColumnName = "baby_id")
    private Baby baby;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Budget budget = (Budget) o;
        return Objects.equals(budgetID, budget.budgetID) && Objects.equals(budgetName, budget.budgetName) && Objects.equals(startdate, budget.startdate) && Objects.equals(enddate, budget.enddate) && Objects.equals(amount, budget.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(budgetID, budgetName, startdate,enddate, amount);
    }
}

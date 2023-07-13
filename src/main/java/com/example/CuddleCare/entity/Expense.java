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
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_ID", nullable = false)
    private Long expenseID;

    @Basic
    @Column(name = "expense_name", nullable = false)
    private String expenseName;


    @Basic
    @Column(name = "date")
    private Date date;

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
        Expense expense = (Expense) o;
        return Objects.equals(expenseID, expense.expenseID) && Objects.equals(expenseName, expense.expenseName) && Objects.equals(date, expense.date) && Objects.equals(amount, expense.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expenseID, expenseName, date, amount);
    }
}

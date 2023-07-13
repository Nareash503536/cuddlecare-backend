package com.example.CuddleCare.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payment")
public class Payment {

    private enum paymentTypes{
        yearly,
        weekly,
        monthly
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_ID", nullable = false)
    private Long paymentID;

    @Basic
    @Column(name = "type")
    private paymentTypes type;

    @Basic
    @Column(name = "amount")
    private Double amount;

    @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "time")
    private Time time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "parent_id")
    private Parents parent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(paymentID, payment.paymentID) && type == payment.type && Objects.equals(amount, payment.amount) && Objects.equals(date, payment.date) && Objects.equals(time, payment.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentID, type, amount, date, time);
    }
}

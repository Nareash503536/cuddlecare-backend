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
@Table(name = "growth_measurement")
public class GrowthMeasurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_ID", nullable = false)
    private Long measurementID;

    @Basic
    @Column(name = "height")
    private Double height;

    @Basic
    @Column(name = "weight")
    private Double weight;

    @Basic
    @Column(name = "head_circumference")
    private Double head_circumference;

    @Basic
    @Column(name = "date")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id", referencedColumnName = "baby_id")
    private Baby baby;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrowthMeasurement that = (GrowthMeasurement) o;
        return Objects.equals(measurementID, that.measurementID) && Objects.equals(height, that.height) && Objects.equals(weight, that.weight) && Objects.equals(head_circumference, that.head_circumference) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(measurementID, height, weight, head_circumference, date);
    }
}

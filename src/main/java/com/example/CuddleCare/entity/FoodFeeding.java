package com.example.CuddleCare.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "food_feeding")
public class FoodFeeding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breast_feeding_ID", nullable = false)
    private Long foodFeedingID;

    @Basic
    @Column(name = "food_type")
    private String foodType;

    @Basic
    @Column(name = "food_variety")
    private String foodVariety;

    @Basic
    @Column(name = "portion__size")
    private String portionSize;

    @Basic
    @Column(name = "additional_notes")
    private String additionalNotes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feeding_id", referencedColumnName = "feeding_id")
    private Feeding feeding;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodFeeding that = (FoodFeeding) o;
        return Objects.equals(foodFeedingID, that.foodFeedingID) && Objects.equals(foodType, that.foodType) && Objects.equals(foodVariety, that.foodVariety) && Objects.equals(portionSize, that.portionSize) && Objects.equals(additionalNotes, that.additionalNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodFeedingID, foodType, foodVariety, portionSize, additionalNotes);
    }
}

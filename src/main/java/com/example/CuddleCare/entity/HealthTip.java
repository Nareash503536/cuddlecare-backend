package com.example.CuddleCare.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "health_tip")
public class HealthTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tip_id", nullable = false)
    private Long tipID;

    @Basic
    @Column(name = "tip")
    private String tip;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id", referencedColumnName = "content_id")
    private Content content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthTip healthTip = (HealthTip) o;
        return Objects.equals(tipID, healthTip.tipID) && Objects.equals(tip, healthTip.tip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipID, tip);
    }
}

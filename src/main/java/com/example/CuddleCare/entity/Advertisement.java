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
@Table(name = "advertisement")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advertisement_id", nullable = false)
    private Long advertisementID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return Objects.equals(advertisementID, that.advertisementID) && Objects.equals(caption, that.caption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(advertisementID, caption);
    }

    @Basic
    @Column(name = "caption")
    private String caption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contentmanager_id", referencedColumnName = "contentmanager_id")
    private ContentManager contentManager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guestuser_id", referencedColumnName = "guestuser_id")
    private GuestUser guestUser;
}

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
@Table(name = "photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id", nullable = false)
    private Long photoID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_id", referencedColumnName = "media_id")
    private Media media;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(photoID, photo.photoID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoID);
    }
}

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
@Table(name = "media")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "media_id", nullable = false)
    private Long mediaID;

    @Basic
    @Column(name = "type")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post post;

    @OneToOne(mappedBy = "media", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Photo photo;

    @OneToOne(mappedBy = "media", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Video video;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return Objects.equals(mediaID, media.mediaID) && Objects.equals(type, media.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediaID, type);
    }
}

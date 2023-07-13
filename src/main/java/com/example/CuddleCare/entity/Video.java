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
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id", nullable = false)
    private Long videoID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_id", referencedColumnName = "media_id")
    private Media media;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return Objects.equals(videoID, video.videoID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(videoID);
    }
}

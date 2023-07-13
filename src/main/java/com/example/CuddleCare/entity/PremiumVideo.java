package com.example.CuddleCare.entity;

import lombok.*;
import net.bytebuddy.matcher.CollectionOneToOneMatcher;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "premium_video")
public class PremiumVideo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pVideo_id", nullable = false)
    private Long pVideo_id;

    @Basic
    @Column(name = "category")
    private String category;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id", referencedColumnName = "content_id")
    private Content content;
}

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
@Table(name = "users")
public class Content {

    private enum types{HealthTip, PremiumVideo}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id", nullable = false)
    private Long contentID;

    @Basic
    @Column(name = "type")
    private types type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content content = (Content) o;
        return Objects.equals(contentID, content.contentID) && type == content.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentID, type);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private ContentManager contentManager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posted_content_manager", referencedColumnName = "contentmanager_id")
    private ContentManager postedContentManager;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "content")
    private PremiumVideo premiumVideo;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "content")
    private HealthTip healthTip;
}

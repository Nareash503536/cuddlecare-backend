package com.example.CuddleCare.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "contentmanager")
public class ContentManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contentmanager_id", nullable = false)
    private Long contentManagerID;

    @OneToMany(mappedBy = "postedContentManager", cascade = CascadeType.ALL)
    private Set<Content> contents = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContentManager that = (ContentManager) o;
        return Objects.equals(contentManagerID, that.contentManagerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentManagerID);
    }

    @OneToMany(mappedBy = "contentManager", cascade = CascadeType.ALL)
    private Set<Advertisement> advertisements = new HashSet<>();
}

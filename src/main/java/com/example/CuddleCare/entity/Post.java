package com.example.CuddleCare.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_ID", nullable = false)
    private Long postID;

    @Basic
    @Column(name = "caption")
    private String caption;

    @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "time")
    private Time time;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "parent_post",
        joinColumns = {@JoinColumn(name = "post_id", referencedColumnName = "post_id")},
        inverseJoinColumns = {@JoinColumn(name = "parent_id", referencedColumnName = "parent_id")})
    private Set<Parents> parents = new HashSet<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Reaction> reactions = new HashSet<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Media> mediaSet = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postID, post.postID) && Objects.equals(caption, post.caption) && Objects.equals(date, post.date) && Objects.equals(time, post.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postID, caption, date, time);
    }
}

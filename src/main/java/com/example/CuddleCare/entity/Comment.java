package com.example.CuddleCare.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comment")
public class Comment implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "parent_id")
    private Parents parent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(commentID, comment.commentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentID);
    }

    @Basic
    @Column(name = "parent_comment_id")
    private Long parentCommentID;

    @Basic
    @Column(name = "comment")
    private String comment;

    @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "time")
    private Time time;
}

package com.example.CuddleCare.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "parent")
public class Parents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id", nullable = false)
    private Long parentID;

    @Basic
    @Column(name = "pro_access", columnDefinition = "boolean default false")
    private Boolean proAccess;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<Reminder> reminders = new HashSet<>();

    @ManyToMany(mappedBy = "parents", fetch = FetchType.LAZY)
    private Set<Post> posts = new HashSet<>();

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<Reaction> reactions = new HashSet<>();

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "parent_baby",
            joinColumns = {@JoinColumn(name = "parent_id", referencedColumnName = "parent_id")},
            inverseJoinColumns = {@JoinColumn(name = "baby_id", referencedColumnName = "baby_id")})
    private Set<Baby> babies = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parents parents = (Parents) o;
        return Objects.equals(parentID, parents.parentID) && Objects.equals(proAccess, parents.proAccess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentID, proAccess);
    }
}



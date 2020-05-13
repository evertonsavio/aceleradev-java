package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "challenge")
@EntityListeners(AuditingEntityListener.class)
public class Challenge {

    public Challenge() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull
    @Size(max=100)
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @NotNull
    @Size(max=50)
    @Column(name = "slug", length = 50, nullable = false)
    private String slug;

    @CreatedDate
    private LocalDateTime created_at;

    ///////////////////////////////////////////////////////////////////////

    @OneToMany(mappedBy = "challenge")
    private Set<Submission> submissions;

    @OneToMany(mappedBy = "challenge")
    private Set<Acceleration> accelerations;

    ///////////////////////////////////////////////////////////////////////


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Set<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(Set<Submission> submissions) {
        this.submissions = submissions;
    }

    public Set<Acceleration> getAccelerations() {
        return accelerations;
    }

    public void setAccelerations(Set<Acceleration> accelerations) {
        this.accelerations = accelerations;
    }
}

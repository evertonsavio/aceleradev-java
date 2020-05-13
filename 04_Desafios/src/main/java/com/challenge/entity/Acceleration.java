package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "acceleration")
@EntityListeners(AuditingEntityListener.class)
public class Acceleration {

    public Acceleration() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    /////////////////////RELACIONAMENTOS//////////////////////

    @OneToMany(mappedBy = "acceleration")
    private Set<Candidate> candidates;

    @ManyToOne
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

    ///////////////////////////////////////////////////////////


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

    public Set<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(Set<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}

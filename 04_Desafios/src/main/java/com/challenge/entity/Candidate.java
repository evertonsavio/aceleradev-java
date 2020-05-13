package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "candidate")
@EntityListeners(AuditingEntityListener.class)
public class Candidate {

    public Candidate() {}

    @EmbeddedId
    private CandidatePKey candidatePKey;

    @NotNull
    @Column(name = "status", nullable = false)
    private int status;

    @CreatedDate
    private LocalDateTime created_at;

    ///////////////////////////////////////////////////////


    public CandidatePKey getCandidatePKey() {
        return candidatePKey;
    }

    public void setCandidatePKey(CandidatePKey candidatePKey) {
        this.candidatePKey = candidatePKey;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}

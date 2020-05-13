package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "submission")
@EntityListeners(AuditingEntityListener.class)
public class Submission {

    public Submission() {}

    @EmbeddedId
    private SubmissionPKey submissionPKey;

    @NotNull
    @Column(nullable = false)
    private float score;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    //////////////////////////////////////////////////////////////


    public SubmissionPKey getSubmissionPKey() {
        return submissionPKey;
    }

    public void setSubmissionPKey(SubmissionPKey submissionPKey) {
        this.submissionPKey = submissionPKey;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}

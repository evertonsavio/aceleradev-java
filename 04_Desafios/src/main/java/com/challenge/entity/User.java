package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {

    public User() {
    //Requirements (public or protected, no-argument constructor) for Entity Classes
    }

    ///////////////////INICIO CRIACAO DAS COLUNAS////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name = "full_name", length = 100, nullable = false)
    private String full_name;

    @Email
    @NotNull
    @NotBlank
    @Size(max=100)
    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "nickname", length = 50, nullable = false)
    private String nickname;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String password;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;
    ///////////////////FINAL CRIACAO DAS COLUNAS////////////////////////

    //////////////////////INICIO RELACIONAMENTOS////////////////////////

    @OneToMany(mappedBy = "user")
    private Set<Submission> submissions;

    //Shared Primary Key -> Foreign Key
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Candidate candidate;

    //////////////////////FINAL RELACIONAMENTOS////////////////////////


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}

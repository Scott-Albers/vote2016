package com.scottbal.entities;


import com.scottbal.enums.Ethnicity;
import com.scottbal.enums.Gender;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "voters")
public class Voter {
    private int id;
    private int version;
    private String name;
    private int age;
    private Gender gender;
    private Ethnicity ethnicity;
    private List<Candidate> candidate;
    private State state;
    private Date createdAt;
    private Date updatedAt;

    public Voter() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Voter(int id) {
        this();
        this.id = id;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "candidate_voter",
            joinColumns = @JoinColumn(name = "voter_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "id"))
    public List<Candidate> getCandidate() { return candidate; }
    public void setCandidate(List<Candidate> candidate) {
        this.candidate = candidate;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "state_id2")
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('M', 'F')", nullable = false)
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Asian', 'White', 'PacificIslander', 'Native', 'Black', 'Other')", nullable = false)
    public Ethnicity getEthnicity() {
        return ethnicity;
    }
    public void setEthnicity(Ethnicity ethnicity) {
        this.ethnicity = ethnicity;
    }

    @Column(name = "created_at", nullable = false)
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "updated_at", nullable = false)
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

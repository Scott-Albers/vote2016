package com.scottbal.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "states")
public class State {
    private int id;
    private int version;
    private String name;
    private int electVotes;
    private Date createdAt;
    private Date updatedAt;

    public State() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public State(int id) {
        this();
        this.id = id;
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

    @Column(name = "elect_votes", nullable = false)
    public int getElectVotes() {
        return electVotes;
    }
    public void setElectVotes(int electVotes) {
        this.electVotes = electVotes;
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

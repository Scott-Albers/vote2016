package com.scottbal.entities;

import com.scottbal.enums.Party;
import com.scottbal.enums.Position;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "candidates")
public class Candidate {
    private int id;
    private int version;
    private String name;
    private Position position;
    private Party party;
    private State state;
    private Date createdAt;
    private Date updatedAt;

    public Candidate() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Candidate(int id){
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

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('President', 'Governor', 'Senator')", nullable = false)
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Democrat', 'Republican')", nullable = false)
    public Party getParty() {
        return party;
    }
    public void setParty(Party party) {
        this.party = party;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "state_id")
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
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

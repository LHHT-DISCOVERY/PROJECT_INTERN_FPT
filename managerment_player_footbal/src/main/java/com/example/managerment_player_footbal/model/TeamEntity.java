package com.example.managerment_player_footbal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "team")
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int teamId;
    @ManyToOne
    @JoinColumn(name = "class_id",referencedColumnName = "class_id")
    @JsonBackReference
    private Classes classEntity;
    @Column
    private String teamName;
    @Column
    private int capacity;

    @ManyToMany
    @JoinTable(name = "team_member",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    @JsonManagedReference
    private Set<Player> playerEntities;

    public TeamEntity(int teamId, Classes classEntity, String teamName, int capacity, Set<Player> playerEntities) {
        this.teamId = teamId;
        this.classEntity = classEntity;
        this.teamName = teamName;
        this.capacity = capacity;
        this.playerEntities = playerEntities;
    }

    public TeamEntity() {
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Classes getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(Classes classEntity) {
        this.classEntity = classEntity;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Set<Player> getPlayerEntities() {
        return playerEntities;
    }

    public void setPlayerEntities(Set<Player> playerEntities) {
        this.playerEntities = playerEntities;
    }
}

package com.example.managerment_player_footbal.model;

import com.example.managerment_player_footbal.model.account.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private int classId ;
    private int capacity;

    @Column(name = "className")
    private String className;


    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "coach_id" , referencedColumnName = "coach_id")
    @JsonBackReference
    private Coach coach;



    @OneToMany(mappedBy = "classes")
    @JsonManagedReference
    private Set<Player> playerSet;

    @OneToMany(mappedBy = "classEntity")
    @JsonManagedReference
    private Set<TeamEntity> teamEntities;
    @OneToMany(mappedBy = "Classes")
    @JsonManagedReference
    private Set<CoachRatingEntity> coachRatingEntities;

    public Classes() {
    }

    public Classes(int classId, int capacity, String className, Date startDate, Date endDate, Coach coach, Set<Player> playerSet, Set<TeamEntity> teamEntities, Set<CoachRatingEntity> coachRatingEntities) {
        this.classId = classId;
        this.capacity = capacity;
        this.className = className;
        this.startDate = startDate;
        this.endDate = endDate;
        this.coach = coach;
        this.playerSet = playerSet;
        this.teamEntities = teamEntities;
        this.coachRatingEntities = coachRatingEntities;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Set<Player> getPlayerSet() {
        return playerSet;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<TeamEntity> getTeamEntities() {
        return teamEntities;
    }

    public void setTeamEntities(Set<TeamEntity> teamEntities) {
        this.teamEntities = teamEntities;
    }

    public Set<CoachRatingEntity> getCoachRatingEntities() {
        return coachRatingEntities;
    }

    public void setCoachRatingEntities(Set<CoachRatingEntity> coachRatingEntities) {
        this.coachRatingEntities = coachRatingEntities;
    }

    public void setPlayerSet(Set<Player> playerSet) {
        this.playerSet = playerSet;
    }
}

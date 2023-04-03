package com.example.managerment_player_footbal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "coach_rating")
public class CoachRatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ratingId;
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    @JsonBackReference
    private Classes classes;
    @ManyToOne
    @JoinColumn(name = "coach_id", referencedColumnName = "coach_id")
    @JsonBackReference
    private Coach coachEntity;
    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "player_id")
    @JsonBackReference
    private Player playerEntity;
    @Column
    private int coachTraining;
    @Column
    private int communication;
    @Column
    private int discipline;
    @Column
    private int footballKnowledge;
    @Column
    private int overallRating;
    @Column
    private String otherOpinion;
    @Column(name = "rating_date")
    private Date createDate;


    public CoachRatingEntity() {
    }


    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Coach getCoachEntity() {
        return coachEntity;
    }

    public void setCoachEntity(Coach coachEntity) {
        this.coachEntity = coachEntity;
    }

    public Player getPlayerEntity() {
        return playerEntity;
    }

    public void setPlayerEntity(Player playerEntity) {
        this.playerEntity = playerEntity;
    }

    public int getCoachTraining() {
        return coachTraining;
    }

    public void setCoachTraining(int coachTraining) {
        this.coachTraining = coachTraining;
    }

    public int getCommunication() {
        return communication;
    }

    public void setCommunication(int communication) {
        this.communication = communication;
    }

    public int getDiscipline() {
        return discipline;
    }

    public void setDiscipline(int discipline) {
        this.discipline = discipline;
    }

    public int getFootballKnowledge() {
        return footballKnowledge;
    }

    public void setFootballKnowledge(int footballKnowledge) {
        this.footballKnowledge = footballKnowledge;
    }

    public int getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(int overallRating) {
        this.overallRating = overallRating;
    }

    public String getOtherOpinion() {
        return otherOpinion;
    }

    public void setOtherOpinion(String otherOpinion) {
        this.otherOpinion = otherOpinion;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

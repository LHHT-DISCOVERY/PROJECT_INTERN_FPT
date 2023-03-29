package com.example.managerment_player_footbal.model;

import com.example.managerment_player_footbal.model.account.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int playerId;

    private String name;

    private String avatar;

    private java.sql.Date birthday;

    private Float weight;

    private Float height;

    private String parentPhone;

    @Column
    private String position;

    @OneToOne
    @JoinColumn(name = "account_name", referencedColumnName = "account_name")
    @JsonBackReference
    private Account account;

    @OneToMany(mappedBy = "player")
    @JsonManagedReference
    private Set<PlayerRating> playerRatings;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
//    @JsonBackReference
    private Classes classes;


    @OneToMany(mappedBy = "playerEntity")
    @JsonManagedReference
    private Set<CoachRatingEntity> coachRatingEntities;

    @ManyToMany()
    @JsonBackReference
    private Set<TeamEntity> teamEntities;

    public Player() {
    }

    public Player(int playerId, String name, String avatar, Date birthday, Float weight, Float height, String parentPhone, String position, Account account, Set<PlayerRating> playerRatings, Classes classes, Set<CoachRatingEntity> coachRatingEntities, Set<TeamEntity> teamEntities) {
        this.playerId = playerId;
        this.name = name;
        this.avatar = avatar;
        this.birthday = birthday;
        this.weight = weight;
        this.height = height;
        this.parentPhone = parentPhone;
        this.position = position;
        this.account = account;
        this.playerRatings = playerRatings;
        this.classes = classes;
        this.coachRatingEntities = coachRatingEntities;
        this.teamEntities = teamEntities;
    }



    public Set<CoachRatingEntity> getCoachRatingEntities() {
        return coachRatingEntities;
    }

    public void setCoachRatingEntities(Set<CoachRatingEntity> coachRatingEntities) {
        this.coachRatingEntities = coachRatingEntities;
    }

    public Set<TeamEntity> getTeamEntities() {
        return teamEntities;
    }

    public void setTeamEntities(Set<TeamEntity> teamEntities) {
        this.teamEntities = teamEntities;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public java.sql.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<PlayerRating> getPlayerRatings() {
        return playerRatings;
    }

    public void setPlayerRatings(Set<PlayerRating> playerRatings) {
        this.playerRatings = playerRatings;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}

package com.example.managerment_player_footbal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Entity
public class PlayerRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Rating;

    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "player_id")
    @JsonBackReference
    private Player player;
    @ManyToOne
    @JoinColumn(name = "coach_id", referencedColumnName = "coach_id")
    @JsonBackReference
    private Coach coach;



    private int Speed;


    private int Technique;
    private int Strength;
    private int Jumping;
    private int Defense;
    private int Offense;
    private Date create_date;

    public PlayerRating() {
    }

    public PlayerRating(int ID_Rating, Player player, Coach coach, int speed, int technique, int strength, int jumping, int defense, int offense, Date create_date) {
        this.ID_Rating = ID_Rating;
        this.player = player;
        this.coach = coach;
        Speed = speed;
        Technique = technique;
        Strength = strength;
        Jumping = jumping;
        Defense = defense;
        Offense = offense;
        this.create_date = create_date;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public int getID_Rating() {
        return ID_Rating;
    }

    public void setID_Rating(int ID_Rating) {
        this.ID_Rating = ID_Rating;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public int getTechnique() {
        return Technique;
    }

    public void setTechnique(int technique) {
        Technique = technique;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public int getJumping() {
        return Jumping;
    }

    public void setJumping(int jumping) {
        Jumping = jumping;
    }

    public int getDefense() {
        return Defense;
    }

    public void setDefense(int defense) {
        Defense = defense;
    }

    public int getOffense() {
        return Offense;
    }

    public void setOffense(int offense) {
        Offense = offense;
    }
}

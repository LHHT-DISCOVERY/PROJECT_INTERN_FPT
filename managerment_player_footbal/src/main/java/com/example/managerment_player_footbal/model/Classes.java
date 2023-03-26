package com.example.managerment_player_footbal.model;

import com.example.managerment_player_footbal.model.account.Account;

import javax.persistence.*;

@Entity
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private int capacity;

    @Column(name = "className")
    private String className;

    @OneToOne(targetEntity = Coach.class)
    @JoinColumn(name = "coach_id" , referencedColumnName = "CoachID")
    private Coach coach;

    public Classes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}

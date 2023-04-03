package com.example.managerment_player_footbal.model.account;

import com.example.managerment_player_footbal.model.Coach;
import com.example.managerment_player_footbal.model.Player;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Column(nullable = false, length = 128)
    private String password;


    @OneToOne(mappedBy = "account")
    @JsonManagedReference
    private Player player;

    @OneToOne(mappedBy = "account")
    @JsonManagedReference
    private Coach coach;

    public Account(String accountName, String password, Player player, Coach coach) {
        this.accountName = accountName;
        this.password = password;
        this.player = player;
        this.coach = coach;
    }

    public Account() {
    }

    public Account(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }



    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

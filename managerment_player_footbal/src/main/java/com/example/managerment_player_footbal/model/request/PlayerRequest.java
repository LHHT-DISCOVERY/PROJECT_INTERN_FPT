package com.example.managerment_player_footbal.model.request;


import com.example.managerment_player_footbal.model.Classes;
import com.example.managerment_player_footbal.model.account.Account;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

public class PlayerRequest {
    private int playerId;
    private Classes classId;
    private Account accountName;
    private String name;
    private MultipartFile avatar;
    private Date birthDay;
    private String parentPhone;
    private String position;

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

    public Classes getClassId() {
        return classId;
    }

    public void setClassId(Classes classId) {
        this.classId = classId;
    }

    public Account getAccountName() {
        return accountName;
    }

    public void setAccountName(Account accountName) {
        this.accountName = accountName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }
}

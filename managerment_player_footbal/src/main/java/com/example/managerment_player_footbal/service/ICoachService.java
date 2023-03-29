package com.example.managerment_player_footbal.service;

import com.example.managerment_player_footbal.model.Coach;
import com.example.managerment_player_footbal.model.account.Account;

import java.util.List;
import java.util.Optional;

public interface ICoachService {

    List<Coach>  findAll() ;


    void createOrUpdateCoach(Coach  coach);

    Coach findById(int id);

    void deleteById(int id);

    Coach findCoachByAccount(Account account);



}

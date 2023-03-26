package com.example.managerment_player_footbal.service.CooachService;

import com.example.managerment_player_footbal.model.Coach;

import java.util.List;

public interface ICoachService {

    List<Coach>  findAll() ;

    void createOrUpdateCoach(Coach  coach);

    Coach findById(int id);

    void deleteById(int id);

}

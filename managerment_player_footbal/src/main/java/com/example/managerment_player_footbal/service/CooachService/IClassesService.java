package com.example.managerment_player_footbal.service.CooachService;

import com.example.managerment_player_footbal.model.Classes;
import com.example.managerment_player_footbal.model.Coach;
import com.example.managerment_player_footbal.model.Player;

import java.util.List;

public interface IClassesService {
    List<Classes> findAll() ;

    List<Player>  findAllByIdClass();
}

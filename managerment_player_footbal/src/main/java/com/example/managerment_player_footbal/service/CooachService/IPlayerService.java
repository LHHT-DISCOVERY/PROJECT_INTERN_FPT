package com.example.managerment_player_footbal.service.CooachService;

import com.example.managerment_player_footbal.model.Player;

import java.util.List;

public interface IPlayerService {

    List<Player> findAllByIdClass(int id) ;

    Player getById(int id);
}

package com.example.managerment_player_footbal.service;

import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.model.account.Account;
import com.example.managerment_player_footbal.model.request.PlayerRequest;

import java.util.List;

public interface IPlayerService {

    List<Player> findAllByIdClass(int id) ;

    Player getById(int id);

    Player getByID(int id);
    List<Player> getByClassId(int id);

    Player findByPlayerUserName(String username);

    List<Player> getAll();

    Player save(PlayerRequest playerRequest);



}

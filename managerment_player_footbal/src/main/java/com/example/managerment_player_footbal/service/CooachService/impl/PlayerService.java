package com.example.managerment_player_footbal.service.CooachService.impl;

import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.repository.classes_repository.IPlayerRepository;
import com.example.managerment_player_footbal.service.CooachService.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepository iPlayerRepository ;


    @Override
    public List<Player> findAllByIdClass(int id) {
        return iPlayerRepository.findAllByClassesId(id);
    }

    @Override
    public Player getById(int id) {
        return iPlayerRepository.findByPlayerId(id).orElse(null);
    }
}

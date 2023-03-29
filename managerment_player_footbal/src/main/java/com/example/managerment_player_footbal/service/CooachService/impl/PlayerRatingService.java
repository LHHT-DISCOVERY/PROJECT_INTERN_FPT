package com.example.managerment_player_footbal.service.CooachService.impl;

import com.example.managerment_player_footbal.model.PlayerRating;
import com.example.managerment_player_footbal.repository.classes_repository.IPlayerRatingRepository;
import com.example.managerment_player_footbal.service.CooachService.IPlayerRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerRatingService implements IPlayerRating {
    @Autowired
    IPlayerRatingRepository iPlayerRatingRepository;


    @Override
    public PlayerRating save(PlayerRating player) {
        return iPlayerRatingRepository.save(player);
    }

    @Override
    public PlayerRating getByCoachIdAndPlayerId(int playerId, int coachId) {
        PlayerRating playerRating = iPlayerRatingRepository.findByCoachIdAndPlayerId(playerId,coachId).orElse(new PlayerRating());
        return playerRating;
    }
}

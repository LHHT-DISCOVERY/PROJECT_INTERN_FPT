package com.example.managerment_player_footbal.service.impl;

import com.example.managerment_player_footbal.model.PlayerRating;
import com.example.managerment_player_footbal.repository.classes_repository.IPlayerRatingRepository;
import com.example.managerment_player_footbal.service.IPlayerRating;
import com.example.managerment_player_footbal.service.IPlayerRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerRatingService implements IPlayerRatingService , IPlayerRating{
    IPlayerRatingRepository iPlayerRatingRepository;

    public PlayerRatingService(IPlayerRatingRepository playerRatingRepository) {
        this.iPlayerRatingRepository = playerRatingRepository;
    }

    @Override
    public PlayerRating getByPlayerId(int id) {
        return iPlayerRatingRepository.findByPlayerId(id).orElse(new PlayerRating());
    }

    @Override
    public PlayerRating save(PlayerRating player) {
        return iPlayerRatingRepository.save(player);
    }

    @Override
    public List<PlayerRating> getPlayerRating(int id) {
        return iPlayerRatingRepository.findAllByPlayerId(id);
    }

    @Override
    public PlayerRating getByCoachIdAndPlayerId(int playerId, int coachId) {
        PlayerRating playerRating = iPlayerRatingRepository.findByCoachIdAndPlayerId(playerId,coachId).orElse(new PlayerRating());
        return playerRating;
    }
}

package com.example.managerment_player_footbal.service;

import com.example.managerment_player_footbal.model.PlayerRating;

import java.util.List;

public interface IPlayerRating {
    PlayerRating getByPlayerId(int id);
    PlayerRating save(PlayerRating player);
    PlayerRating getByCoachIdAndPlayerId(int playerId, int coachId);

    List<PlayerRating> getPlayerRating(int id);
}

package com.example.managerment_player_footbal.service.CooachService;

import com.example.managerment_player_footbal.model.PlayerRating;

public interface IPlayerRating {

    PlayerRating save(PlayerRating player);
    PlayerRating getByCoachIdAndPlayerId(int playerId, int coachId);
}

package com.example.managerment_player_footbal.service;


import com.example.managerment_player_footbal.model.PlayerRating;


public interface IPlayerRatingService {
    PlayerRating getByPlayerId(int id);
}

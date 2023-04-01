package com.example.managerment_player_footbal.service;


import com.example.managerment_player_footbal.model.CoachRatingEntity;

public interface ICoachRatingService {

    CoachRatingEntity save(CoachRatingEntity coachRatingEntity);
    CoachRatingEntity getByClassIdAndPlayerId(int classId, int playerId);
}

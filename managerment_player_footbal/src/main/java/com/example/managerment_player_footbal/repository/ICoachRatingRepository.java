package com.example.managerment_player_footbal.repository;

import com.example.managerment_player_footbal.model.CoachRatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICoachRatingRepository extends JpaRepository<CoachRatingEntity,Integer> {
    @Query(nativeQuery = true,value = "SELECT * FROM coach_rating WHERE class_id = ? and player_id = ?")
    Optional<CoachRatingEntity> findByClassIdAndPlayerId(int classId, int playerId);
}

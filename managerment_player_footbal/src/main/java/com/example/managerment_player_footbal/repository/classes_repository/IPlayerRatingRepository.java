package com.example.managerment_player_footbal.repository.classes_repository;

import com.example.managerment_player_footbal.model.PlayerRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IPlayerRatingRepository extends JpaRepository<PlayerRating, Integer> {
    @Query(nativeQuery = true, value = "SELECT top 1 * from player_rating where player_id = ? and coach_id = ? order by id_rating desc")
    Optional<PlayerRating> findByCoachIdAndPlayerId(int playerId, int coachId);


    @Query(nativeQuery = true, value = "SELECT top 1 * from player_rating where player_id = ? order by id_rating desc")
    Optional<PlayerRating> findByPlayerId(int id);

    @Query(nativeQuery = true, value = "SELECT * from player_rating where player_id = ?")
    List<PlayerRating> findAllByPlayerId(int id);
}

package com.example.managerment_player_footbal.repository.medical_repository.PlayerHealthRepository;

import com.example.managerment_player_footbal.model.medical.PlayerHealthReport.PlayerHealthReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerHealthReportRepository extends JpaRepository<PlayerHealthReport,Integer> {
    List<PlayerHealthReport> findById(int id);

    @Query("SELECT p FROM PlayerHealthReport p WHERE p.player.playerId = :playerId")
    List<PlayerHealthReport> findAllByPlayerId(@Param("playerId") int playerId);

}
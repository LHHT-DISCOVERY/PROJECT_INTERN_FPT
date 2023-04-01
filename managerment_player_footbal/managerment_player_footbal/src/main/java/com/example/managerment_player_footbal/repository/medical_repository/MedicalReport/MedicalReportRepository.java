package com.example.managerment_player_footbal.repository.medical_repository.MedicalReport;

import com.example.managerment_player_footbal.model.medical.MedicalReport.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicalReportRepository extends JpaRepository<MedicalReport,Integer> {

    @Query("SELECT p FROM MedicalReport p WHERE p.player.playerId = :playerId")
    List<MedicalReport> findAllByPlayerId(@Param("playerId") int playerId);


}
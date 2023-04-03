package com.example.managerment_player_footbal.repository;

import com.example.managerment_player_footbal.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LICoachRepository extends JpaRepository<Coach, Integer> {
}

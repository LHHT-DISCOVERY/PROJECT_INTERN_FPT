package com.example.managerment_player_footbal.repository.classes_repository;

import com.example.managerment_player_footbal.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlayerRepository extends JpaRepository<Player , Integer> {
    List<Player>  findAllByClassesId(int id) ;
}

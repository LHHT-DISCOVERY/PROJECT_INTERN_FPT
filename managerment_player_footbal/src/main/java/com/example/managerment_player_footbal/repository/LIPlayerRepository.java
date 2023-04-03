package com.example.managerment_player_footbal.repository;

import com.example.managerment_player_footbal.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LIPlayerRepository extends JpaRepository<Player, Integer> {

      @Query(nativeQuery = true, value = "select * from player where class_id = ?")
      List<Player> findAllByClassesId(int classId);

    @Query(nativeQuery = true, value = "select * from player where player_id = ?")
    Player findById(int Id);

    @Query(nativeQuery = true, value = "select account_name from account where account_name = ?1")
    String findByAccountName(String accountName);



}


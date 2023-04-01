package com.example.managerment_player_footbal.repository.classes_repository;

import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IPlayerRepository extends JpaRepository<Player , Integer> {

    @Query(nativeQuery = true, value = "select  * from  player where class_id = ?")
    List<Player> findAllByClassId(int id);


    @Query(nativeQuery = true, value = "select * from player where player_id = ?")
    Optional<Player> findByPlayerId(int id);


    @Query(nativeQuery = true, value = "select * from player where account_name = ?")
    Optional<Player> findByPlayerUserName(String accountName);

    @Query(value = "SELECT * FROM player", nativeQuery = true)
    List<Player> getAll();

    @Query(nativeQuery = true, value = "SELECT * FROM player WHERE class_id = ?")
    List<Player> getByClassId(int id);



}

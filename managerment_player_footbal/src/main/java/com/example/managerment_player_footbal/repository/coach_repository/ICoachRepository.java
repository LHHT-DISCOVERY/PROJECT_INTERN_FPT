package com.example.managerment_player_footbal.repository.coach_repository;

import com.example.managerment_player_footbal.model.Coach;
import com.example.managerment_player_footbal.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICoachRepository extends JpaRepository<Coach, Integer>{

    Coach findCoachByAccount(Account account);

    @Query(nativeQuery = true , value = "select * from coaches")
    List<Coach> getAll();

}

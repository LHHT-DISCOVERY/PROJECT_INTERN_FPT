package com.example.managerment_player_footbal.repository.coach_repository;

import com.example.managerment_player_footbal.model.Coach;
import com.example.managerment_player_footbal.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICoachRepository extends JpaRepository<Coach, Integer>{
    Optional<Coach> findCoachByAccount(Account account);
}

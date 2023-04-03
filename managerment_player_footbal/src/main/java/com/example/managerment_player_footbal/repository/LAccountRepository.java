package com.example.managerment_player_footbal.repository;

import com.example.managerment_player_footbal.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LAccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByAccountName(String accountName);
}

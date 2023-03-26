package com.example.managerment_player_footbal.repository.account_repository;

import com.example.managerment_player_footbal.model.account.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Integer> {
    Account findByAccountName(String accountName);

    List<Account> findAll();
}

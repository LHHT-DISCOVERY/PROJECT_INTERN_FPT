package com.example.managerment_player_footbal.service.CooachService;

import com.example.managerment_player_footbal.model.account.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    Account findByAccountName(String accountName);

     boolean isUsernameExists(String username);

    Account createOrUpdate(Account account);
}
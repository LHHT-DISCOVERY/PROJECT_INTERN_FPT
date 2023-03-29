package com.example.managerment_player_footbal.service.CooachService.impl;

import com.example.managerment_player_footbal.model.account.Account;
import com.example.managerment_player_footbal.repository.account_repository.AccountRepository;
import com.example.managerment_player_footbal.service.CooachService.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public boolean isUsernameExists(String username) {
        Account user = accountRepository.findByAccountName(username);
        return user != null;
    }

    @Override
    public Account findByAccountName(String accountName) {
        return accountRepository.findByAccountName(accountName);
    }

    @Override
    public Account createOrUpdate(Account account) {
        return accountRepository.save(account);
    }
}

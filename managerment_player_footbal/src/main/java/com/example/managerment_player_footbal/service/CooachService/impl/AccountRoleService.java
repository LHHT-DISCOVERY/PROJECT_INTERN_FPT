package com.example.managerment_player_footbal.service.CooachService.impl;

import com.example.managerment_player_footbal.model.account.AccountRole;
import com.example.managerment_player_footbal.model.account.Role;
import com.example.managerment_player_footbal.repository.account_repository.AccountRoleRepository;
import com.example.managerment_player_footbal.service.CooachService.IAccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountRoleService implements IAccountRoleService {
    @Autowired
    AccountRoleRepository accountRoleRepository ;

    @Override
    public AccountRole save(AccountRole accountRole) {
        return accountRoleRepository.save( accountRole);
    }

    @Override
    public List<AccountRole> accountRoleList() {
        return null;
    }
}

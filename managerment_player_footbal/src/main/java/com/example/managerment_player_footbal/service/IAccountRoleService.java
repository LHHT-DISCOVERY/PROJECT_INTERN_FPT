package com.example.managerment_player_footbal.service;

import com.example.managerment_player_footbal.model.account.AccountRole;
import com.example.managerment_player_footbal.model.account.Role;

import java.util.List;

public interface IAccountRoleService {
    AccountRole save(AccountRole accountRole );

    List<AccountRole>  accountRoleList();
}

package com.example.managerment_player_footbal.repository.account_repository;

import com.example.managerment_player_footbal.model.account.AccountRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRoleRepository extends CrudRepository<AccountRole, Integer> {
    @Query("select ar.role.roleName from AccountRole ar where ar.account.accountName = :accountName")
    List<String> findAllRoleByUser(String accountName);
}

package com.example.managerment_player_footbal.service.CooachService.impl;

import com.example.managerment_player_footbal.model.account.Role;
import com.example.managerment_player_footbal.repository.account_repository.IRoleRepository;
import com.example.managerment_player_footbal.service.CooachService.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    IRoleRepository iRoleRepository ;
    @Override
    public List<Role> findAll() {
        return iRoleRepository.findAll();
    }

    @Override
    public Role get(Long roleId) {
        return iRoleRepository.findById(roleId).orElse(null);
    }
}

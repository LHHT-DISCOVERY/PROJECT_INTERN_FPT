package com.example.managerment_player_footbal.service;

import com.example.managerment_player_footbal.model.account.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IRoleService {

    List<Role> findAll() ;

    Role get(Long roleId);
}

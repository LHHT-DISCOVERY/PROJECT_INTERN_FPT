package com.example.managerment_player_footbal.repository.account_repository;

import com.example.managerment_player_footbal.model.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<Role , Long> {
    List<Role>  findAll() ;
}

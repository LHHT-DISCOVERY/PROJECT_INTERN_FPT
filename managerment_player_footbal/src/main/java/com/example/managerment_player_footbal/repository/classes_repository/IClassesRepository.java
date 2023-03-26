package com.example.managerment_player_footbal.repository.classes_repository;

import com.example.managerment_player_footbal.model.Classes;
import com.example.managerment_player_footbal.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface IClassesRepository extends JpaRepository<Classes , Integer> {


}

package com.example.managerment_player_footbal.repository;

import com.example.managerment_player_footbal.model.Classes;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LIClassesRepository extends JpaRepository<Classes , Integer> {
    @Query(nativeQuery = true, value = "select * from classes where class_id=?")
    Optional<Classes> findById(int classId);


}
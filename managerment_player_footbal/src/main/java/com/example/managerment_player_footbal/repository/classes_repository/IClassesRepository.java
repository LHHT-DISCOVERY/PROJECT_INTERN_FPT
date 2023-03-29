package com.example.managerment_player_footbal.repository.classes_repository;

import com.example.managerment_player_footbal.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClassesRepository extends JpaRepository<Classes , Integer> {
    @Query(nativeQuery = true, value = "select * from classes")
    List<Classes> getAll();

    Optional<Classes> findByClassId(int id);


}

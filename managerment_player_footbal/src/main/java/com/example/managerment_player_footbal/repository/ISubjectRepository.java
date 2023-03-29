package com.example.managerment_player_footbal.repository;

import com.example.managerment_player_footbal.model.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISubjectRepository extends JpaRepository<SubjectEntity, Integer> {
    Optional<SubjectEntity> getBySubjectId(int id);

    @Query(value = "SELECT * FROM subject", nativeQuery = true)
    List<SubjectEntity> getAll();
}

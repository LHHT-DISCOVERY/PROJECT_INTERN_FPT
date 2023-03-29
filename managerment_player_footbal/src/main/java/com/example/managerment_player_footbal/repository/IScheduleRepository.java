package com.example.managerment_player_footbal.repository;

import com.example.managerment_player_footbal.model.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface IScheduleRepository extends JpaRepository<ScheduleEntity, Integer> {
    Optional<ScheduleEntity> getByClassId(int id);

    List<ScheduleEntity> getByScheduleDate(Date date);
}

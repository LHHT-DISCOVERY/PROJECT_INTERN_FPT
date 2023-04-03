package com.example.managerment_player_footbal.service.impl;

import com.example.managerment_player_footbal.model.Classes;
import com.example.managerment_player_footbal.model.Coach;
import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.repository.classes_repository.IClassesRepository;
import com.example.managerment_player_footbal.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassService implements IClassesService {
    @Autowired
    IClassesRepository iClassesRepository;

    @Override
    public void deleteById(int id) {
        iClassesRepository.deleteById(id);
    }

    @Override
    public void save(Classes classes) {
        iClassesRepository.save(classes);
    }

    @Override
    public List<Classes> findAll() {
        return iClassesRepository.findAll().stream().map(entity -> {
            Classes classes = new Classes();
            classes.setClassId(entity.getClassId());
            classes.setClassName(entity.getClassName());
            classes.setCapacity(entity.getCapacity());
            classes.setStartDate(new Date(entity.getStartDate().getTime()));
            classes.setEndDate(new Date(entity.getEndDate().getTime()));
            classes.setCoach(entity.getCoach());
            classes.setPlayerSet(entity.getPlayerSet());
            classes.setTeamEntities(entity.getTeamEntities());
            classes.setCoachRatingEntities(entity.getCoachRatingEntities());
            return classes;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Classes> findAllByCoach(Coach coach) {
        return iClassesRepository.findAllClassesByCoach(coach);
    }


    @Override
    public Classes findAllByIdClass(int id) {
        return iClassesRepository.findByClassId(id).orElse(new Classes());
    }
}

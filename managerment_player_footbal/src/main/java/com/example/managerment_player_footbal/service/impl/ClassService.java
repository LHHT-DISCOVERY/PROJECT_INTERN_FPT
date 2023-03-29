package com.example.managerment_player_footbal.service.impl;

import com.example.managerment_player_footbal.model.Classes;
import com.example.managerment_player_footbal.model.Coach;
import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.repository.classes_repository.IClassesRepository;
import com.example.managerment_player_footbal.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassesService {
    @Autowired
    IClassesRepository iClassesRepository;

    @Override
    public List<Classes> findAll() {
        return iClassesRepository.findAll();
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

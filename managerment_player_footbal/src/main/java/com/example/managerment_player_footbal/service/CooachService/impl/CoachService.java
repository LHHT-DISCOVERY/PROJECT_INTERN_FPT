package com.example.managerment_player_footbal.service.CooachService.impl;

import com.example.managerment_player_footbal.model.Coach;
import com.example.managerment_player_footbal.repository.coach_repository.ICoachRepository;
import com.example.managerment_player_footbal.service.CooachService.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService implements ICoachService {
    @Autowired
    ICoachRepository  iCoachRepository ;

    @Override
    public List<Coach> findAll() {
        return iCoachRepository.findAll();
    }

    @Override
    public void createOrUpdateCoach(Coach coach) {
        iCoachRepository.save(coach);
    }

    @Override
    public Coach findById(int id) {
        return iCoachRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        iCoachRepository.deleteById(id);
    }
}

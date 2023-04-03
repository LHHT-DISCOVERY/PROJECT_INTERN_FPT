package com.example.managerment_player_footbal.service.impl;

import com.example.managerment_player_footbal.model.Coach;
import com.example.managerment_player_footbal.model.account.Account;
import com.example.managerment_player_footbal.repository.coach_repository.ICoachRepository;
import com.example.managerment_player_footbal.service.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoachService implements ICoachService {
    @Autowired
    ICoachRepository  iCoachRepository ;

    @Override
    public List<Coach> findAll() {
        List<Coach> coaches = iCoachRepository.getAll();
        return coaches;
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

    @Override
    public Coach findCoachByAccount(Account account) {
        return iCoachRepository.findCoachByAccount(account);
    }
}

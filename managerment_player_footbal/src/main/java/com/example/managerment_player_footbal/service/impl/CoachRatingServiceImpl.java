package com.example.managerment_player_footbal.service.impl;


import com.example.managerment_player_footbal.model.CoachRatingEntity;
import com.example.managerment_player_footbal.repository.ICoachRatingRepository;
import com.example.managerment_player_footbal.service.ICoachRatingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CoachRatingServiceImpl implements ICoachRatingService {
    private final ICoachRatingRepository coachRatingRepository;
    private final ModelMapper modelMapper;

    public CoachRatingServiceImpl(ICoachRatingRepository coachRatingRepository, ModelMapper modelMapper) {
        this.coachRatingRepository = coachRatingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CoachRatingEntity save(CoachRatingEntity coachRatingEntity) {
        return coachRatingRepository.save(coachRatingEntity);
    }

    @Override
    public CoachRatingEntity getByClassIdAndPlayerId(int classId,int playerId) {
        return coachRatingRepository.findByClassIdAndPlayerId(classId,playerId).orElse(new CoachRatingEntity());
    }
}

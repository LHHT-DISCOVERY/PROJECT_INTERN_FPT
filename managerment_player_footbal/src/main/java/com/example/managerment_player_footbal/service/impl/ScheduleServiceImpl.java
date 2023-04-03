package com.example.managerment_player_footbal.service.impl;

import com.example.managerment_player_footbal.model.ScheduleEntity;
import com.example.managerment_player_footbal.model.reponse.ScheduleResponse;
import com.example.managerment_player_footbal.repository.IScheduleRepository;
import com.example.managerment_player_footbal.service.IScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements IScheduleService {
    private final IScheduleRepository scheduleRepository;
    private final ModelMapper modelMapper;
    public ScheduleServiceImpl(IScheduleRepository scheduleRepository, ModelMapper modelMapper) {
        this.scheduleRepository = scheduleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ScheduleEntity getByClassId(int id) {
        return scheduleRepository.getByClassId(id).orElse(new ScheduleEntity());
    }

    @Override
    public List<ScheduleResponse> getByDate(Date date) {
        return scheduleRepository.getByScheduleDate(date).stream().map(entity -> {
            ScheduleResponse response = new ScheduleResponse();
            response.setScheduleId(entity.getScheduleId());
            response.setClassId(entity.getClassId());
            response.setSubjectId(entity.getSubjectId());
            response.setScheduleDate(entity.getScheduleDate());
            response.setStartTime((String.format("%02d",entity.getStartTime().getHours())) + ":" +
                    (String.format("%02d",entity.getStartTime().getMinutes())) +
                    (entity.getStartTime().toLocalTime().getHour() > 12 ? " PM" : " AM"));
            response.setEndTime((String.format("%02d",entity.getEndTime().getHours())) + ":" +
                    (String.format("%02d",entity.getEndTime().getMinutes())) +
                    (entity.getEndTime().toLocalTime().getHour() > 12 ? " PM" : " AM"));
            response.setLocation(entity.getLocation());
            response.setTrainingDescription(entity.getTrainingDescription());
            return response;
        }).collect(Collectors.toList());
    }
}

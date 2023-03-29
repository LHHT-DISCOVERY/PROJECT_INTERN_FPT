package com.example.managerment_player_footbal.service;


import com.example.managerment_player_footbal.model.ScheduleEntity;
import com.example.managerment_player_footbal.model.reponse.ScheduleResponse;

import java.sql.Date;
import java.util.List;

public interface IScheduleService {
    ScheduleEntity getByClassId(int id);
    List<ScheduleResponse> getByDate(Date date);
}

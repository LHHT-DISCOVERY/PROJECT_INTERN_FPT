package com.example.managerment_player_footbal.service;



import com.example.managerment_player_footbal.model.SubjectEntity;

import java.util.List;

public interface ISubjectService {
    SubjectEntity getById(int id);
    List<SubjectEntity> getAll();
}

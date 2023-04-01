package com.example.managerment_player_footbal.service.impl;

import com.example.managerment_player_footbal.model.SubjectEntity;
import com.example.managerment_player_footbal.repository.ISubjectRepository;
import com.example.managerment_player_footbal.service.ISubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements ISubjectService {
    private final ISubjectRepository subjectRepository;

    public SubjectServiceImpl(ISubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public SubjectEntity getById(int id) {
        return subjectRepository.getBySubjectId(id).orElse(new SubjectEntity());
    }

    @Override
    public List<SubjectEntity> getAll() {
        return subjectRepository.getAll();
    }
}

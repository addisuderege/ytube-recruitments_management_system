package com.codehooks.rms.service.impl;

import com.codehooks.rms.dto.InterviewDto;
import com.codehooks.rms.dao.InterviewRepo;
import com.codehooks.rms.entity.Interview;
import com.codehooks.rms.exceptions.DataNotFoundException;
import com.codehooks.rms.exceptions.RecordDeleteException;
import com.codehooks.rms.mappers.InterviewMapper;
import com.codehooks.rms.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private InterviewRepo interviewRepo;
    @Autowired
    private InterviewMapper interviewMapper;

    @Override
    public List<InterviewDto> findAll() {
        List<Interview> categories = interviewRepo.findAll();
        if (categories == null || categories.isEmpty()) {
            throw new DataNotFoundException("Records Not Found");
        }
        return interviewMapper.toDtoList(categories);
    }

    @Override
    public InterviewDto findById(String id) {
        Optional<Interview> category = interviewRepo.findById(id);
        category.orElseThrow(() -> new DataNotFoundException("Record Not Found with the id : " + id));
        return interviewMapper.toDto(category.get());
    }

    @Override
    public InterviewDto save(InterviewDto interview) {
        Interview category = interviewRepo.save(interviewMapper.fromDto(interview));
        return interviewMapper.toDto(category);
    }

    @Override
    public InterviewDto update(InterviewDto interview) {
        Interview category = interviewRepo.save(interviewMapper.fromDto(interview));
        return interviewMapper.toDto(category);
    }

    @Override
    public boolean delete(String id) {
        Optional<Interview> record = interviewRepo.findById(id);
        record.orElseThrow(() -> new RecordDeleteException("Record not found with id : " + id));
        try {
            interviewRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecordDeleteException("Error occurred while deleting the record with id : " + "id");
        }
    }


}
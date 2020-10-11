package com.codehooks.rms.service.impl;

import com.codehooks.rms.dto.StepDto;
import com.codehooks.rms.dao.StepRepo;
import com.codehooks.rms.entity.Step;
import com.codehooks.rms.exceptions.DataNotFoundException;
import com.codehooks.rms.exceptions.RecordDeleteException;
import com.codehooks.rms.mappers.StepMapper;
import com.codehooks.rms.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StepServiceImpl implements StepService {

    @Autowired
    private StepRepo stepRepo;
    @Autowired
    private StepMapper stepMapper;

    @Override
    public List<StepDto> findAll() {
        List<Step> categories = stepRepo.findAll();
        if (categories == null || categories.isEmpty()) {
            throw new DataNotFoundException("Records Not Found");
        }
        return stepMapper.toDtoList(categories);
    }

    /*
    @Override
    public StepDto findById(String id) {
        Optional<Step> category = stepRepo.findById(id);
        category.orElseThrow(() -> new DataNotFoundException("Record Not Found with the id : " + id));
        return stepMapper.toDto(category.get());
    }*/

    @Override
    public StepDto save(StepDto step) {
        Step category = stepRepo.save(stepMapper.fromDto(step));
        return stepMapper.toDto(category);
    }

    @Override
    public StepDto update(StepDto step) {
        Step category = stepRepo.save(stepMapper.fromDto(step));
        return stepMapper.toDto(category);
    }

    @Override
    public boolean delete(String id) {
        Optional<Step> record = stepRepo.findById(id);
        record.orElseThrow(() -> new RecordDeleteException("Record not found with id : " + id));
        try {
            stepRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecordDeleteException("Error occurred while deleting the record with id : " + "id");
        }
    }


}
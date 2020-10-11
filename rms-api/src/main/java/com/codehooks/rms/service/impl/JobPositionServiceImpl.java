
package com.codehooks.rms.service.impl;

import com.codehooks.rms.dto.JobPositionDto;
import com.codehooks.rms.dao.JobPositionRepo;
import com.codehooks.rms.entity.JobPosition;
import com.codehooks.rms.exceptions.DataNotFoundException;
import com.codehooks.rms.exceptions.RecordDeleteException;
import com.codehooks.rms.mappers.JobPositionMapper;
import com.codehooks.rms.service.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPositionServiceImpl implements JobPositionService {

    @Autowired
    private JobPositionRepo jobPositionRepo;
    @Autowired
    private JobPositionMapper jobPositionMapper;

    @Override
    public List<JobPositionDto> findAll() {
        List<JobPosition> categories = jobPositionRepo.findAll();
        if (categories == null || categories.isEmpty()) {
            throw new DataNotFoundException("Records Not Found");
        }
        return jobPositionMapper.toDtoList(categories);
    }

    @Override
    public JobPositionDto findById(String id) {
        Optional<JobPosition> category = jobPositionRepo.findById(id);
        category.orElseThrow(() -> new DataNotFoundException("Record Not Found with the id : " + id));
        return jobPositionMapper.toDto(category.get());
    }

    @Override
    public JobPositionDto save(JobPositionDto jobPosition) {
        JobPosition category = jobPositionRepo.save(jobPositionMapper.fromDto(jobPosition));
        return jobPositionMapper.toDto(category);
    }

    @Override
    public JobPositionDto update(JobPositionDto jobPosition) {
        JobPosition category = jobPositionRepo.save(jobPositionMapper.fromDto(jobPosition));
        return jobPositionMapper.toDto(category);
    }

    @Override
    public boolean delete(String id) {
        Optional<JobPosition> record = jobPositionRepo.findById(id);
        record.orElseThrow(() -> new RecordDeleteException("Record not found with id : " + id));
        try {
            jobPositionRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecordDeleteException("Error occurred while deleting the record with id : " + "id");
        }
    }


}
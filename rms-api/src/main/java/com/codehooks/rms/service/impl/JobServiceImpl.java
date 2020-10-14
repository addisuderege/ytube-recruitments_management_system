package com.codehooks.rms.service.impl;

import com.codehooks.rms.dto.JobDto;
import com.codehooks.rms.dao.JobRepo;
import com.codehooks.rms.entity.Job;
import com.codehooks.rms.exceptions.DataNotFoundException;
import com.codehooks.rms.exceptions.RecordDeleteException;
import com.codehooks.rms.mappers.JobMapper;
import com.codehooks.rms.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepo jobRepo;
    @Autowired
    private JobMapper jobMapper;

    @Override
    public List<JobDto> findAll() {
        List<Job> categories = jobRepo.findAll();
        if (categories == null || categories.isEmpty()) {
            throw new DataNotFoundException("Records Not Found");
        }
        return jobMapper.toDtoList(categories);
    }

    @Override
    public JobDto findById(String id) {
        Optional<Job> category = jobRepo.findById(id);
        category.orElseThrow(() -> new DataNotFoundException("Record Not Found with the id : " + id));
        return jobMapper.toDto(category.get());
    }

    @Override
    public JobDto save(JobDto job) {
        Job category = jobRepo.save(jobMapper.fromDto(job));
        return jobMapper.toDto(category);
    }

    @Override
    public JobDto update(JobDto job) {
        Job category = jobRepo.save(jobMapper.fromDto(job));
        return jobMapper.toDto(category);
    }

    @Override
    public boolean delete(String id) {
        Optional<Job> record = jobRepo.findById(id);
        record.orElseThrow(() -> new RecordDeleteException("Record not found with id : " + id));
        try {
            jobRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecordDeleteException("Error occurred while deleting the record with id : " + "id");
        }
    }


}
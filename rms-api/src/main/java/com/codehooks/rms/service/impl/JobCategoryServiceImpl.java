package com.codehooks.rms.service.impl;

import com.codehooks.rms.dao.JobCategoryRepo;
import com.codehooks.rms.dto.JobCategoryDto;
import com.codehooks.rms.entity.JobCategory;
import com.codehooks.rms.exceptions.DataNotFoundException;
import com.codehooks.rms.exceptions.RecordDeleteException;
import com.codehooks.rms.mappers.JobCategoryMapper;
import com.codehooks.rms.service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobCategoryServiceImpl implements JobCategoryService {

    @Autowired
    private JobCategoryRepo repo;
    @Autowired
    private JobCategoryMapper mapper;

    @Override
    public List<JobCategoryDto> findAll() {
        List<JobCategory> categories = repo.findAll();
        if(categories == null || categories.isEmpty()) {
            throw new DataNotFoundException("Records Not Found");
        }
        return mapper.toDtoList(categories);
    }

    @Override
    public JobCategoryDto findById(String id) {
        Optional<JobCategory> category = repo.findById(id);
        category.orElseThrow(() -> new DataNotFoundException("Record Not Found with the id : " + id));
        return mapper.toDto(category.get());
    }

    @Override
    public JobCategoryDto save(JobCategoryDto jobCategory) {
        JobCategory category = repo.save(mapper.fromDto(jobCategory));
        return mapper.toDto(category);
    }

    @Override
    public JobCategoryDto update(JobCategoryDto jobCategory) {
        JobCategory category = repo.save(mapper.fromDto(jobCategory));
        return mapper.toDto(category);
    }

    @Override
    public boolean delete(String id) {
        Optional<JobCategory> record = repo.findById(id);
        record.orElseThrow(() -> new RecordDeleteException("Record not found with id : "+ id));
        try {
            repo.deleteById(id);
            return true;
        } catch (Exception e) {
           throw new RecordDeleteException("Error occurred while deleting the record with id : " + "id");
        }
    }


}

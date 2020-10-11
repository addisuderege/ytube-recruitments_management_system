package com.codehooks.rms.service.impl;

import com.codehooks.rms.dao.JobCategoryRepo;
import com.codehooks.rms.dto.JobCategoryDto;
import com.codehooks.rms.entity.JobCategory;
import com.codehooks.rms.mappers.JobCategoryMapper;
import com.codehooks.rms.service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobCategoryServiceImpl implements JobCategoryService {

    @Autowired
    private JobCategoryRepo repo;
    @Autowired
    private JobCategoryMapper mapper;

    @Override
    public List<JobCategoryDto> findAll() {
        List<JobCategory> categories = repo.findAll();
        return mapper.toDtoList(categories);
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
        try {
            repo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

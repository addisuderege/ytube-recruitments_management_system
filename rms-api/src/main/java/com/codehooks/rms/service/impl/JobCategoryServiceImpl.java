package com.codehooks.rms.service.impl;

import com.codehooks.rms.dao.JobCategoryRepo;
import com.codehooks.rms.entity.JobCategory;
import com.codehooks.rms.service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobCategoryServiceImpl implements JobCategoryService {

    @Autowired
    private JobCategoryRepo repo;

    @Override
    public List<JobCategory> findAll() {
        return repo.findAll();
    }

    @Override
    public JobCategory save(JobCategory jobCategory) {
        return repo.save(jobCategory);
    }

    @Override
    public JobCategory update(JobCategory jobCategory) {
        return repo.save(jobCategory);
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

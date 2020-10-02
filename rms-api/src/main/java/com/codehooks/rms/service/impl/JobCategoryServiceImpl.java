package com.codehooks.rms.service.impl;

import com.codehooks.rms.DataFeed;
import com.codehooks.rms.entity.JobCategory;
import com.codehooks.rms.service.JobCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobCategoryServiceImpl implements JobCategoryService {

    @Override
    public List<JobCategory> findAll() {
        return DataFeed.jobCategories;
    }

    @Override
    public JobCategory save(JobCategory jobCategory) {
        return null;
    }

    @Override
    public JobCategory update(JobCategory jobCategory) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}

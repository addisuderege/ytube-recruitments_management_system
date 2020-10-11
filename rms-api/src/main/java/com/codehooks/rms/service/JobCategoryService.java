package com.codehooks.rms.service;

import com.codehooks.rms.dto.JobCategoryDto;

public interface JobCategoryService extends GenericService<JobCategoryDto> {

    JobCategoryDto findById(String id);
}

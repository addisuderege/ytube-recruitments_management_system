package com.codehooks.rms.service;

import com.codehooks.rms.dto.JobDto;

public interface JobService extends GenericService<JobDto> {

    JobDto findById(String id);

}
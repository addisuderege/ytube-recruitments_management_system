package com.codehooks.rms.service;

import com.codehooks.rms.dto.JobPositionDto;

public interface JobPositionService extends GenericService<JobPositionDto> {

    JobPositionDto findById(String id);

}
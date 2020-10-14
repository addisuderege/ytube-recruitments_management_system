package com.codehooks.rms.service;

import com.codehooks.rms.dto.InterviewDto;

public interface InterviewService extends GenericService<InterviewDto> {

    InterviewDto findById(String id);

}
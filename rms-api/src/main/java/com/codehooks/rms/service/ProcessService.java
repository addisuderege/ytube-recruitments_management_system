package com.codehooks.rms.service;

import com.codehooks.rms.dto.ProcessDto;

public interface ProcessService extends GenericService<ProcessDto> {

    ProcessDto findById(String id);

}
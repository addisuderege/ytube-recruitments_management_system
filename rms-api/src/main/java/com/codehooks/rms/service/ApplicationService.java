package com.codehooks.rms.service;

import com.codehooks.rms.dto.ApplicationDto;

public interface ApplicationService extends GenericService<ApplicationDto> {

    ApplicationDto findById(String id);

}
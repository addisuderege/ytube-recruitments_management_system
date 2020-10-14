package com.codehooks.rms.service;

import com.codehooks.rms.dto.ApplicationStatusDto;

public interface ApplicationStatusService extends GenericService<ApplicationStatusDto> {

    ApplicationStatusDto findById(String id);

}
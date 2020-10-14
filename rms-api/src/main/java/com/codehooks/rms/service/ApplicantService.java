package com.codehooks.rms.service;

import com.codehooks.rms.dto.ApplicantDto;

public interface ApplicantService extends GenericService<ApplicantDto> {

    ApplicantDto findById(String id);

}
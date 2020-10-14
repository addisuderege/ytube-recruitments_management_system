package com.codehooks.rms.service;

import com.codehooks.rms.dto.RoundDto;

public interface RoundService extends GenericService<RoundDto> {

    RoundDto findById(String id);

}
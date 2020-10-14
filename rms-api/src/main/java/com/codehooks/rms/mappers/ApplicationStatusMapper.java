package com.codehooks.rms.mappers;

import com.codehooks.rms.dto.ApplicationStatusDto;
import com.codehooks.rms.entity.ApplicationStatus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationStatusMapper {

    ApplicationStatusDto toDto(ApplicationStatus applicationStatus);

    ApplicationStatus fromDto(ApplicationStatusDto applicationStatusDto);

    List<ApplicationStatusDto> toDtoList(List<ApplicationStatus> applicationStatusCollection);

    List<ApplicationStatus> fromDtoList(List<ApplicationStatusDto> applicationStatusCollection);

}
package com.codehooks.rms.mappers;

import com.codehooks.rms.dto.ApplicationDto;
import com.codehooks.rms.entity.Application;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    ApplicationDto toDto(Application application);

    Application fromDto(ApplicationDto applicationDto);

    List<ApplicationDto> toDtoList(List<Application> applicationCollection);

    List<Application> fromDtoList(List<ApplicationDto> applicationCollection);

}
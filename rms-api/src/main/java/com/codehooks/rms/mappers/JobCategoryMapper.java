package com.codehooks.rms.mappers;

import com.codehooks.rms.dto.JobCategoryDto;
import com.codehooks.rms.entity.JobCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobCategoryMapper {

    JobCategoryDto toDto(JobCategory category);

    JobCategory fromDto(JobCategoryDto categoryDto);

    List<JobCategoryDto> toDtoList(List<JobCategory> categories);

    List<JobCategory> fromDtoList(List<JobCategoryDto> categoryDtos);

}

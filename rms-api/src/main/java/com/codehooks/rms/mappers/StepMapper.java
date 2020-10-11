package com.codehooks.rms.mappers;

import com.codehooks.rms.dto.StepDto;
import com.codehooks.rms.entity.Step;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StepMapper {

    StepDto toDto(Step step);

    Step fromDto(StepDto stepDto);

    List<StepDto> toDtoList(List<Step> stepCollection);

    List<Step> fromDtoList(List<StepDto> stepCollection);

}
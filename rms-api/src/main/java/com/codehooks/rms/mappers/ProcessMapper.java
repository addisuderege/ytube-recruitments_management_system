package com.codehooks.rms.mappers;

import com.codehooks.rms.dto.ProcessDto;
import com.codehooks.rms.entity.Process;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProcessMapper {

    ProcessDto toDto(Process process);

    Process fromDto(ProcessDto processDto);

    List<ProcessDto> toDtoList(List<Process> processCollection);

    List<Process> fromDtoList(List<ProcessDto> processCollection);

}
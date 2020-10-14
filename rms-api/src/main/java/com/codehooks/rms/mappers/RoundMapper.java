package com.codehooks.rms.mappers;

import com.codehooks.rms.dto.RoundDto;
import com.codehooks.rms.entity.Round;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoundMapper {

    RoundDto toDto(Round round);

    Round fromDto(RoundDto roundDto);

    List<RoundDto> toDtoList(List<Round> roundCollection);

    List<Round> fromDtoList(List<RoundDto> roundCollection);

}
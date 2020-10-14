package com.codehooks.rms.mappers;

import com.codehooks.rms.dto.ApplicantDto;
import com.codehooks.rms.entity.Applicant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicantMapper {

    ApplicantDto toDto(Applicant applicant);

    Applicant fromDto(ApplicantDto applicantDto);

    List<ApplicantDto> toDtoList(List<Applicant> applicantCollection);

    List<Applicant> fromDtoList(List<ApplicantDto> applicantCollection);

}
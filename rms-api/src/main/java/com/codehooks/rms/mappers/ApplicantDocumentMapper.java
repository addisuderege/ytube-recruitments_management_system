package com.codehooks.rms.mappers;

import com.codehooks.rms.dto.ApplicantDocumentDto;
import com.codehooks.rms.entity.ApplicantDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicantDocumentMapper {

    ApplicantDocumentDto toDto(ApplicantDocument applicantDocument);

    ApplicantDocument fromDto(ApplicantDocumentDto applicantDocumentDto);

    List<ApplicantDocumentDto> toDtoList(List<ApplicantDocument> applicantDocumentCollection);

    List<ApplicantDocument> fromDtoList(List<ApplicantDocumentDto> applicantDocumentCollection);

}
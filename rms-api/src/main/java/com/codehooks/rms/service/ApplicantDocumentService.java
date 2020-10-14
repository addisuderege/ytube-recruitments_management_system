package com.codehooks.rms.service;

import com.codehooks.rms.dto.ApplicantDocumentDto;

public interface ApplicantDocumentService extends GenericService<ApplicantDocumentDto> {

    ApplicantDocumentDto findById(String id);

}
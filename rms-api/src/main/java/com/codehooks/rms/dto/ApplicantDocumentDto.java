package com.codehooks.rms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicantDocumentDto {
    private String id;
    private String name;
    private byte[] document;
    private String docType;
    private String extension;
}

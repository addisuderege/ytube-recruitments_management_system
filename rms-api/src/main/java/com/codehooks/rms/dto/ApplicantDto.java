package com.codehooks.rms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicantDto {
    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String idType;
    private String idNumber;
    private List<String> documentIds;
    private byte[] resume;
}

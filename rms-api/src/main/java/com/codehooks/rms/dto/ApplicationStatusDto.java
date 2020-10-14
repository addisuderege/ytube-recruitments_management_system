package com.codehooks.rms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationStatusDto {

    private String id;
    private String status;
    private String interviewId;
    private String applicationId;
    private String lastUpdated;

}

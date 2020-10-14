package com.codehooks.rms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobDto {

    private String id;
    private String jobCode;
    private String jobName;
    private String jobDescription;
    private int noOfVacancies;
    private String jobCategoryId;
    private String processId;
    private String jobPositionId;

}

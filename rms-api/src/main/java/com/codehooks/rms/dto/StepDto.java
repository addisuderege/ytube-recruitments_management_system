package com.codehooks.rms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StepDto {

    private String id;
    private String stepCode;
    private String stepName;
    private String stepDescription;

}

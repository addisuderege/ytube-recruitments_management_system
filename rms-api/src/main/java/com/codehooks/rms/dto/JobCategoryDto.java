package com.codehooks.rms.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class JobCategoryDto {

    private String id;
    private String jobCategoryCode;
    private String jobCategoryName;
    private String description;

}

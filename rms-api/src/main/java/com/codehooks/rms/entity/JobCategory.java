package com.codehooks.rms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobCategory {
    private String id;
    private String jobCategoryCode;
    private String jobCategoryName;
    private String description;
}

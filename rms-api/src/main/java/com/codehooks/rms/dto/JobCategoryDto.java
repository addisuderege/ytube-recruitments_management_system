package com.codehooks.rms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobCategoryDto {

    private String id;
    @NotNull(message = "Job Category Code Should not be null")
    private String jobCategoryCode;
    @NotNull(message = "Job Category Name Should not be null")
    private String jobCategoryName;
    @NotNull(message = "Description Should not be null")
    private String description;

}

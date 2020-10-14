package com.codehooks.rms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "job")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String jobCode;
    private String jobName;
    private String jobDescription;
    private int noOfVacancies;
    private String jobCategoryId;
    private String processId;
    private String jobPositionId;
}

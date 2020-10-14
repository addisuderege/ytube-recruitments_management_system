package com.codehooks.rms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "applicationStatus")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationStatus {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String status;
    private String interviewId;
    private String applicationId;
    private String lastUpdated;
}

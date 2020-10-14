package com.codehooks.rms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Document(collection = "application")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private LocalDateTime appliedDate;
    private String jobId;
    private String applicantId;
}

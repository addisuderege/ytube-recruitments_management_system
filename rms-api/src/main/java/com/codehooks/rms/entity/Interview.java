package com.codehooks.rms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "interview")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Interview {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String applicationId;
    private String processId;
    private String jobId;
    private String overallFeedback;

}

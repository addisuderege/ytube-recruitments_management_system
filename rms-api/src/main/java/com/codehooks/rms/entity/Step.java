package com.codehooks.rms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "step")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Step {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String stepCode;
    private String stepName;
    private String stepDescription;
}

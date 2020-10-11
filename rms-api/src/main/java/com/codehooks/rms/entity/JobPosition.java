package com.codehooks.rms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "jobPosition")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPosition {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @Indexed
    private String positionCode;
    private String positionName;
    private String positionDescription;
}

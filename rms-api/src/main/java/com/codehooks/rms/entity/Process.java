package com.codehooks.rms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "process")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Process {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String processCode;
    private String processName;
    private String processDescription;
    private List<String> stepIds;
}

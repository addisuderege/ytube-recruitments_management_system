package com.codehooks.rms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "applicant_document")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantDocument {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String name;
    private byte[] document;
    private String docType;
    private String extension;
}

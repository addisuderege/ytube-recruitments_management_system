package com.codehooks.rms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "applicant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Applicant {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String idType;
    private String idNumber;
    private List<String> documentIds;
    private byte[] resume;

}

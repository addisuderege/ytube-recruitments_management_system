package com.codehooks.rms.entity;

import com.codehooks.rms.dto.StepFeedbackDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Round {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private LocalDateTime scheduledTime;
    private List<String> interviewers;
    private List<StepFeedbackDto> feedback;
    private String status;
    private String stepId;
    private String overallFeedback;
}

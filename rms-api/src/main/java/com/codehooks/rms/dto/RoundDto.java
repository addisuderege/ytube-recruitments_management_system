package com.codehooks.rms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoundDto {

    private String id;
    private LocalDateTime scheduledTime;
    private List<String> interviewers;
    private List<StepFeedbackDto> feedback;
    private String status;
    private String stepId;
    private String overallFeedback;

}

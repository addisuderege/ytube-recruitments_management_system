package com.codehooks.rms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.AssertFalse;

@Data
@AllArgsConstructor
@Builder
public class ResponseDto {

    private String message;
    private Object data;
    private Boolean success;
}

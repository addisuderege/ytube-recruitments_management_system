package com.codehooks.rms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcessDto {

    private String id;
    private String processCode;
    private String processName;
    private String processDescription;
    @NotNull(message = "Step Ids Should Not be null")
    private List<String> stepIds;

}

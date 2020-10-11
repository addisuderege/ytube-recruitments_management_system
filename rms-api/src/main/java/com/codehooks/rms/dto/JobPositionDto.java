package com.codehooks.rms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobPositionDto {

    private String id;
    @NotNull(message = "Position Code Should Not be null")
    private String positionCode;
    private String positionName;
    private String positionDescription;

}

package com.road.roadbe.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Builder
public class ReacceptanceResponse {
    private String roadName;
    private LocalDate date ;
    private String warrantyPeriod;
}

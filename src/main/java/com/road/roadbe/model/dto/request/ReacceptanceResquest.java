package com.road.roadbe.model.dto.request;



import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@Builder
public class ReacceptanceResquest {
    private String roadName;
    private LocalDate date ;
    private String warrantyPeriod;
    private Long idRoad;
}

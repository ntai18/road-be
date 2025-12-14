package com.road.roadbe.model.dto.request;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@Data
@AllArgsConstructor
@Builder
public class ReacceptanceResquest {
    private String roadName;
    private LocalDate date ;
    private String warrantyPeriod;
    private Long idRoad;
}

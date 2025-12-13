package com.road.roadbe.model.dto.request;

import com.road.roadbe.type.CtptStatusType;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoadSearchRequest {
    private String address;
    private String parentRoad;
    private String name;
    private String territory;
    private LocalDate handoverDate;
    private String investor;
    private CtptStatusType ctptStatus;
}

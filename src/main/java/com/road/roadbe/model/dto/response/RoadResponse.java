package com.road.roadbe.model.dto.response;



import com.road.roadbe.type.CtptStatusType;
import com.road.roadbe.type.RoadHandoverStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Builder
public class RoadResponse {
    private String name;
    private String parentRoad;
    private String territory;
    private String management;
    private String startPoint;
    private String endPoint;
    private String distanceFromKm0;
    private String address;
    private Double roadEdgeDistance;
    private Double length;
    private Double width;
    private String investor;
    private String handoverMinutes;
    private String handoverMinutesNumber;
    private LocalDate handoverDate;
    private Integer progress;
    private CtptStatusType ctptStatus;
    private RoadHandoverStatus roadHandoverStatus;
    private String note;
}

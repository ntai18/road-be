package com.road.roadbe.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.road.roadbe.type.CtptStatusType;
import com.road.roadbe.type.RoadHandoverStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class RoadRequest {
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate handoverDate;
    private Integer progress;
    private CtptStatusType ctptStatus;
    private RoadHandoverStatus roadHandoverStatus;
    private String note;
}

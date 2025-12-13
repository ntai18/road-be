package com.road.roadbe.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Builder
public class RoadDisplayResponse {
    private String name;
    private String parentRoad;
    private String territory;
    private String management;
    private String startPoint;
    private String endPoint;
    private String address;
    private String investor;
    private LocalDate handoverDate;
    private Integer progress;
}

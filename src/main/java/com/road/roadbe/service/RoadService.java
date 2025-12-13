package com.road.roadbe.service;

import com.road.roadbe.model.dto.request.RoadRequest;
import com.road.roadbe.model.dto.request.RoadSearchRequest;
import com.road.roadbe.model.dto.response.RoadDisplayResponse;
import com.road.roadbe.model.dto.response.RoadResponse;
import java.util.List;

public interface RoadService {
    RoadResponse createRoad(RoadRequest roadRequest);
    List<RoadDisplayResponse> getAllRoads();
    RoadResponse updateRoad(Long id, RoadRequest roadRequest);
    void deleteRoad(Long id);
    List<RoadDisplayResponse> search(RoadSearchRequest roadSearchRequest);
}

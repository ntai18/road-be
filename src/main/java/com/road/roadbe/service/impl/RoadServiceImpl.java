package com.road.roadbe.service.impl;

import com.road.roadbe.model.dto.request.RoadRequest;
import com.road.roadbe.model.dto.request.RoadSearchRequest;
import com.road.roadbe.model.dto.response.RoadDisplayResponse;
import com.road.roadbe.model.dto.response.RoadResponse;
import com.road.roadbe.model.entity.Road;
import com.road.roadbe.repository.RoadRepository;
import com.road.roadbe.service.RoadService;
import com.road.roadbe.type.CtptStatusType;
import com.road.roadbe.type.RoadHandoverStatus;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoadServiceImpl implements RoadService {
    private final RoadRepository roadRepository;


    @Override
    public RoadResponse createRoad(RoadRequest roadRequest) {
        Road road = new Road();
        road.setName(roadRequest.getName());
        road.setParentRoad(roadRequest.getParentRoad());
        road.setTerritory(roadRequest.getTerritory());
        road.setManagement(roadRequest.getManagement());
        road.setStartPoint(roadRequest.getStartPoint());
        road.setEndPoint(roadRequest.getEndPoint());
        road.setDistanceFromKm0(roadRequest.getDistanceFromKm0());
        road.setAddress(roadRequest.getAddress());
        road.setRoadEdgeDistance(roadRequest.getRoadEdgeDistance());
        road.setLength(roadRequest.getLength());
        road.setWidth(roadRequest.getWidth());
        road.setInvestor(roadRequest.getInvestor());
        road.setHandoverMinutes(roadRequest.getHandoverMinutes());
        road.setHandoverMinutesNumber(roadRequest.getHandoverMinutesNumber());
        road.setHandoverDate(roadRequest.getHandoverDate());
        road.setProgress(roadRequest.getProgress());
        road.setCtptStatus(CtptStatusType.fromCtpt(String.valueOf(roadRequest.getCtptStatus())));
        road.setRoadHandoverStatus(RoadHandoverStatus.fromRoadHandoverStatus(String.valueOf(roadRequest.getRoadHandoverStatus())));
        road.setNote(roadRequest.getNote());
        roadRepository.save(road);
        return RoadResponse.builder()
                .name(road.getName())
                .parentRoad(road.getParentRoad())
                .territory(road.getTerritory())
                .management(road.getManagement())
                .startPoint(road.getStartPoint())
                .endPoint(road.getEndPoint())
                .distanceFromKm0(road.getDistanceFromKm0())
                .address(road.getAddress())
                .roadEdgeDistance(road.getRoadEdgeDistance())
                .length(road.getLength())
                .width(road.getWidth())
                .investor(road.getInvestor())
                .handoverMinutes(road.getHandoverMinutes())
                .handoverMinutesNumber(road.getHandoverMinutesNumber())
                .handoverDate(road.getHandoverDate())
                .progress(road.getProgress())
                .ctptStatus(road.getCtptStatus())
                .roadHandoverStatus(road.getRoadHandoverStatus())
                .note(road.getNote())
                .build();
    }

    @Override
    public List<RoadDisplayResponse> getAllRoads() {

         List<Road> roadList = roadRepository.findAllBy();

         return roadList.stream()
                    .map(road -> RoadDisplayResponse.builder()
                                                          .name(road.getName())
                                                          .parentRoad(road.getParentRoad())
                                                          .address(road.getAddress())
                                                          .progress(road.getProgress())
                                                          .territory(road.getTerritory())
                                                          .management(road.getManagement())
                                                          .startPoint(road.getStartPoint())
                                                          .endPoint(road.getEndPoint())
                                                          .investor(road.getInvestor())
                                                          .handoverDate(road.getHandoverDate())
                                                          .build()
                    )
                    .toList();
    }

    @Override
    public RoadResponse updateRoad(Long id, RoadRequest roadRequest) {
        Road road = roadRepository.findById(id).orElseThrow(()-> new RuntimeException("road not found"));
        applyUpdate(roadRequest, road);
        return RoadResponse.builder()
                .name(road.getName())
                .startPoint(road.getStartPoint())
                .endPoint(road.getEndPoint())
                .investor(road.getInvestor())
                .address(road.getAddress())
                .distanceFromKm0(road.getDistanceFromKm0())
                .roadEdgeDistance(road.getRoadEdgeDistance())
                .length(road.getLength())
                .width(road.getWidth())
                .handoverMinutes(road.getHandoverMinutes())
                .handoverMinutesNumber(road.getHandoverMinutesNumber())
                .handoverDate(road.getHandoverDate())
                .progress(road.getProgress())
                .ctptStatus(road.getCtptStatus())
                .roadHandoverStatus(road.getRoadHandoverStatus())
                .territory(road.getTerritory())
                .parentRoad(road.getParentRoad())
                .management(road.getManagement())
                .note(road.getNote())
                .build();
    }

    private void applyUpdate(RoadRequest roadRequest, Road road) {
        if (StringUtils.isNotBlank(roadRequest.getName()))
            road.setName(roadRequest.getName());

        if (StringUtils.isNotBlank(roadRequest.getParentRoad()))
            road.setParentRoad(roadRequest.getParentRoad());

        if (StringUtils.isNotBlank(roadRequest.getTerritory()))
            road.setTerritory(roadRequest.getTerritory());

        if (StringUtils.isNotBlank(roadRequest.getManagement()))
            road.setManagement(roadRequest.getManagement());

        if (StringUtils.isNotBlank(roadRequest.getStartPoint()))
            road.setStartPoint(roadRequest.getStartPoint());

        if (StringUtils.isNotBlank(roadRequest.getEndPoint()))
            road.setEndPoint(roadRequest.getEndPoint());

        if (StringUtils.isNotBlank(roadRequest.getDistanceFromKm0()))
            road.setDistanceFromKm0(roadRequest.getDistanceFromKm0());

        if (StringUtils.isNotBlank(roadRequest.getAddress()))
            road.setAddress(roadRequest.getAddress());

        if (roadRequest.getRoadEdgeDistance() != null)
            road.setRoadEdgeDistance(roadRequest.getRoadEdgeDistance());

        if (roadRequest.getLength() != null)
            road.setLength(roadRequest.getLength());

        if (roadRequest.getWidth() != null)
            road.setWidth(roadRequest.getWidth());

        if (StringUtils.isNotBlank(roadRequest.getInvestor()))
            road.setInvestor(roadRequest.getInvestor());

        if (StringUtils.isNotBlank(roadRequest.getHandoverMinutes()))
            road.setHandoverMinutes(roadRequest.getHandoverMinutes());

        if (StringUtils.isNotBlank(roadRequest.getHandoverMinutesNumber()))
            road.setHandoverMinutesNumber(roadRequest.getHandoverMinutesNumber());

        if (roadRequest.getHandoverDate() != null)
            road.setHandoverDate(roadRequest.getHandoverDate());

        if (roadRequest.getProgress() != null)
            road.setProgress(roadRequest.getProgress());

        if (roadRequest.getCtptStatus() != null)
            road.setCtptStatus(roadRequest.getCtptStatus());

        if (roadRequest.getRoadHandoverStatus() != null)
            road.setRoadHandoverStatus(roadRequest.getRoadHandoverStatus());

        if (StringUtils.isNotBlank(roadRequest.getNote()))
            road.setNote(roadRequest.getNote());
    }

    @Override
    public void deleteRoad(Long id) {
        Road road = roadRepository.findById(id).orElseThrow(()-> new RuntimeException("road not found"));
        roadRepository.delete(road);
    }

    @Override
    public List<RoadDisplayResponse> search(RoadSearchRequest roadSearchRequest) {
        List<Road> road = roadRepository.search(emptyToNull(roadSearchRequest.getAddress()) ,
                                                emptyToNull(roadSearchRequest.getParentRoad()),
                                                emptyToNull(roadSearchRequest.getName()),
                                                emptyToNull(roadSearchRequest.getTerritory()),
                                                (roadSearchRequest.getHandoverDate() == null ? LocalDate.EPOCH : roadSearchRequest.getHandoverDate()),
                                                emptyToNull(roadSearchRequest.getInvestor()),
                                                (roadSearchRequest.getCtptStatus() == null ? CtptStatusType.ACTIVE: roadSearchRequest.getCtptStatus()));
        return road.stream()
                    .map(roads -> RoadDisplayResponse.builder()
                                                          .name(roads.getName())
                                                          .address(roads.getAddress())
                                                          .progress(roads.getProgress())
                                                          .territory(roads.getTerritory())
                                                          .management(roads.getManagement())
                                                          .startPoint(roads.getStartPoint())
                                                          .endPoint(roads.getEndPoint())
                                                          .investor(roads.getInvestor())
                                                          .handoverDate(roads.getHandoverDate())
                                                          .build()
                    )
                    .toList();
    }
    private <T> String emptyToNull(T val) {
        if (val == null) return "";
        if (val.toString().isEmpty()) return "";
        return val.toString();
    }

}

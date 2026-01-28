package com.road.roadbe.controller;

import com.road.roadbe.model.dto.request.RoadRequest;
import com.road.roadbe.model.dto.request.RoadSearchRequest;
import com.road.roadbe.model.dto.response.RoadDisplayResponse;
import com.road.roadbe.model.dto.response.RoadResponse;
import com.road.roadbe.service.RoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/road")
@RequiredArgsConstructor
public class RoadController {
    private final RoadService roadService;
    @PostMapping("/create")
    public RoadResponse createRoad(@RequestBody RoadRequest roadRequest) {
        return roadService.createRoad(roadRequest);
    }
    @GetMapping("/all")
    public List<RoadDisplayResponse> getAllRoads() {
        return roadService.getAllRoads();
    }
    @PatchMapping("/update/{id}")
    public RoadResponse updateRoad(@PathVariable Long id, @RequestBody RoadRequest roadRequest) {
        return roadService.updateRoad(id, roadRequest);
    }
    @PostMapping("/delete/{id}")
    public void createRoad(@PathVariable Long id) {
        roadService.deleteRoad(id);
    }
    @GetMapping("/search")
    public List<RoadDisplayResponse> searchRoads(@RequestBody RoadSearchRequest roadSearchRequest) {
        return roadService.search(roadSearchRequest); 
    }
}

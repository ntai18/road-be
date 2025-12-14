package com.road.roadbe.controller;

import com.road.roadbe.model.dto.request.ReacceptanceResquest;
import com.road.roadbe.model.dto.response.ReacceptanceResponse;
import com.road.roadbe.service.ReacceptanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reacceptance")
public class ReacceptanceController {
    private final ReacceptanceService reacceptanceService;
    @PostMapping("/create")
    public ReacceptanceResponse create(@RequestBody ReacceptanceResquest reacceptanceResquest) {
        return reacceptanceService.createReacceptance(reacceptanceResquest);
    }
}

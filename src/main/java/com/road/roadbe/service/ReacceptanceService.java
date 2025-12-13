package com.road.roadbe.service;

import com.road.roadbe.model.dto.request.ReacceptanceResquest;
import com.road.roadbe.model.dto.response.ReacceptanceResponse;

public interface ReacceptanceService {
    ReacceptanceResponse createReacceptance(ReacceptanceResquest reacceptanceResquest);
}

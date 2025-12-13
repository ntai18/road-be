package com.road.roadbe.service.impl;

import com.road.roadbe.model.dto.request.ReacceptanceResquest;
import com.road.roadbe.model.dto.response.ReacceptanceResponse;
import com.road.roadbe.model.entity.Reacceptance;
import com.road.roadbe.model.entity.Road;
import com.road.roadbe.repository.ReacceptanceRepository;
import com.road.roadbe.repository.RoadRepository;
import com.road.roadbe.service.ReacceptanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReacceptanceServiceImpl implements ReacceptanceService {
    private final RoadRepository roadRepository;
    private final ReacceptanceRepository reacceptanceRepository;
    @Override
    public ReacceptanceResponse createReacceptance(ReacceptanceResquest reacceptanceResquest) {
        Road road = roadRepository.findById(reacceptanceResquest.getIdRoad()).orElseThrow(()-> new RuntimeException("road not found"));
        Reacceptance reacceptance = new Reacceptance();
        reacceptance.setRoadName(reacceptanceResquest.getRoadName());
        reacceptance.setDate(reacceptanceResquest.getDate());
        reacceptance.setWarrantyPeriod(reacceptanceResquest.getWarrantyPeriod());
        reacceptance.setRoad(road);
        reacceptanceRepository.save(reacceptance);
        return ReacceptanceResponse.builder()
                .roadName(reacceptance.getRoadName())
                .date(reacceptance.getDate())
                .warrantyPeriod(reacceptance.getWarrantyPeriod())
                .build();
    }
}

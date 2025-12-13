package com.road.roadbe.repository;

import com.road.roadbe.model.dto.request.ReacceptanceResquest;
import com.road.roadbe.model.entity.Reacceptance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReacceptanceRepository extends JpaRepository<Reacceptance,Long> {

}

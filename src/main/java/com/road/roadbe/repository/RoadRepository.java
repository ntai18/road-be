package com.road.roadbe.repository;

import com.road.roadbe.model.dto.response.RoadResponse;
import com.road.roadbe.model.entity.Road;
import com.road.roadbe.type.CtptStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoadRepository extends JpaRepository<Road, Long> {
    List<Road> findAllBy();
    Optional<Road> findById(Long id);

    @Query("""
            SELECT r FROM Road r
            WHERE (:address IS NULL OR r.address LIKE %:address%)
            AND (:parentRoad IS NULL OR r.parentRoad LIKE %:parentRoad%)
            AND (:name IS NULL OR r.name LIKE %:name%)
            AND (:territory IS NULL OR r.territory LIKE %:territory%)
            AND (:handoverDate IS NULL OR r.handoverDate = :handoverDate)
            AND (:investor IS NULL OR r.investor LIKE %:investor%)
            AND (:ctptStatus IS NULL OR r.ctptStatus = :ctptStatus)
            """)
        List<Road> search(
        @Param("address") String address,
        @Param("parentRoad") String parentRoad,
        @Param("name") String name,
        @Param("territory") String territory,
        @Param("handoverDate") LocalDate handoverDate,
        @Param("investor") String investor,
        @Param("ctptStatus") CtptStatusType ctptStatus
        );
}

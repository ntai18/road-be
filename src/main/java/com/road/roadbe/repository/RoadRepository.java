package com.road.roadbe.repository;
import com.road.roadbe.model.entity.Road;
import com.road.roadbe.type.CtptStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoadRepository extends JpaRepository<Road, Long> {
    List<Road> findAllBy();
    Optional<Road> findById(Long id);
    @Query( """
            SELECT r FROM Road r
            WHERE (:address IS NULL OR LOWER(r.address) LIKE LOWER(CONCAT('%', :address, '%')))
            AND (:parentRoad IS NULL OR LOWER(r.parentRoad) LIKE LOWER(CONCAT('%', :parentRoad, '%')))
            AND (:name IS NULL OR LOWER(r.name) LIKE LOWER(CONCAT('%', :name, '%')))
            AND (:territory IS NULL OR LOWER(r.territory) LIKE LOWER(CONCAT('%', :territory, '%')))
            AND (r.handoverDate > :handoverDate)
            AND (:investor IS NULL OR LOWER(r.investor) LIKE LOWER(CONCAT('%', :investor, '%')))
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

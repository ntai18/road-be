package com.road.roadbe.model.entity;

import com.road.roadbe.type.CtptStatusType;
import com.road.roadbe.type.RoadHandoverStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "road")
@Getter
@Setter
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "parent_road")
    private String parentRoad;

    @Column(name = "territory" , nullable = false)
    private String territory;

    @Column(name = "management", nullable = false)
    private String management;


    @Column(name = "start_point")
    private String startPoint;

    @Column(name = "end_point")
    private String endPoint;

    @Column(name = "distance_from_km0")
    private String distanceFromKm0;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "road_edge_distance")
    private Double roadEdgeDistance;

    @Column(name = "length")
    @NotNull
    private Double length;

    @Column(name = "width")
    @NotNull
    private Double width;

    @Column(name = "investor", nullable = false)
    private String investor;

    @Column(name = "handover_minutes", nullable = false)
    private String handoverMinutes;

    @Column(name = "handover_minutes_number", nullable = false)
    private String handoverMinutesNumber;

    @Column(name = "handover_date")
    private LocalDate handoverDate;

    @Column(name = "progress")
    private Integer progress;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CtptStatusType ctptStatus;

    @Column(nullable = false )
    @Enumerated(EnumType.STRING)
    private RoadHandoverStatus roadHandoverStatus;

    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Reacceptance> reacceptances;




}

package com.road.roadbe.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "reacceptance")
@Getter
@Setter
public class Reacceptance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "road_name")
    private String roadName;

    private LocalDate date ;
    @Column(name = "warranty_period")
    private String warrantyPeriod;

    @ManyToOne
    @JoinColumn(name = "road_id", nullable = false)
    private Road road;

}

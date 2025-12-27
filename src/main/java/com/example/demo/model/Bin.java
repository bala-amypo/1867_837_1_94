package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bins")
// @Data removed to prevent value-based equality on empty objects
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Bin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String identifier;
    private String locationDescription;
    private Double latitude;
    private Double longitude;
    private Double capacityLiters;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;
}
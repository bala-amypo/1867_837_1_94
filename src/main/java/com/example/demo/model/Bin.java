package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(
    name = "bins",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "identifier")
    }
)
public class Bin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String identifier;

    @Column(name = "location_description")
    private String locationDescription;

    private Double latitude;

    private Double longitude;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;

    @Column(name = "capacity_liters", nullable = false)
    private Double capacityLiters;

    @Column(nullable = false)
    private Boolean active;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    /*
     * Logical relationships
     * Bin is NOT the owner, so mappedBy is used
     * No cascade, no fetch = EAGER (intentional)
     */

    @OneToMany(mappedBy = "bin")
    private List<FillLevelRecord> fillLevelRecords;

    @OneToMany(mappedBy = "bin")
    private List<OverflowPrediction> overflowPredictions;

    // ---------- Constructors ----------

    public Bin() {
        // JPA
    }

    public Bin(
            String identifier,
            String locationDescription,
            Double latitude,
            Double longitude,
            Zone zone,
            Double capacityLiters,
            Boolean active,
            Timestamp createdAt,
            Timestamp updatedAt
    ) {
        this.identifier = identifier;
        this.locationDescription = locationDescription;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zone = zone;
        this.capacityLiters = capacityLiters;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // ---------- Lifecycle hooks ----------

    @PrePersist
    protected void onCreate() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        this.createdAt = now;
        this.updatedAt = now;

        // SPEC: active defaults to true
        if (this.active == null) {
            this.active = true;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    // ---------- Getters & Setters ----------

    public Long getId() {
        return id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Double getCapacityLiters() {
        return capacityLiters;
    }

    public void setCapacityLiters(Double capacityLiters) {
        this.capacityLiters = capacityLiters;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
}

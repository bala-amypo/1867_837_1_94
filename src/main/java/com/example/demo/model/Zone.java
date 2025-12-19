package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(
    name = "zones",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "zone_name")
    }
)
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zone_name", nullable = false, unique = true)
    private String zoneName;

    @Column
    private String description;

    @Column(nullable = false)
    private Boolean active;

    /*
     * Logical one-to-many:
     * One zone can have many bins.
     * Ownership is on Bin.zone
     */
    @OneToMany(mappedBy = "zone")
    private List<Bin> bins;

    // ---------- Constructors ----------

    public Zone() {
        // required by JPA
    }

    public Zone(String zoneName, String description, Boolean active) {
        this.zoneName = zoneName;
        this.description = description;
        this.active = active;
    }

    // ---------- Lifecycle hooks ----------

    @PrePersist
    protected void onCreate() {
        /*
         * Spec:
         * active defaults to true on creation
         */
        if (this.active == null) {
            this.active = true;
        }
    }

    // ---------- Getters & Setters ----------

    public Long getId() {
        return id;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Bin> getBins() {
        return bins;
    }
}

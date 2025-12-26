package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usage_pattern_models")
public class UsagePatternModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bin_id")
    private Bin bin;

    @Column(nullable = false)
    private Double avgDailyIncreaseWeekday;

    @Column(nullable = false)
    private Double avgDailyIncreaseWeekend;

    @Column(nullable = false)
    private LocalDateTime lastUpdated;

    @PrePersist
    protected void onCreate() {
        this.lastUpdated = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdated = LocalDateTime.now();
    }

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public Bin getBin() {
        return bin;
    }

    public void setBin(Bin bin) {
        this.bin = bin;
    }

    public Double getAvgDailyIncreaseWeekday() {
        return avgDailyIncreaseWeekday;
    }

    public void setAvgDailyIncreaseWeekday(Double avgDailyIncreaseWeekday) {
        this.avgDailyIncreaseWeekday = avgDailyIncreaseWeekday;
    }

    public Double getAvgDailyIncreaseWeekend() {
        return avgDailyIncreaseWeekend;
    }

    public void setAvgDailyIncreaseWeekend(Double avgDailyIncreaseWeekend) {
        this.avgDailyIncreaseWeekend = avgDailyIncreaseWeekend;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}

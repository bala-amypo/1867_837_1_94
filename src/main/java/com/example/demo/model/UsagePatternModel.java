package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(
    name = "usage_pattern_models",
    indexes = {
        @Index(name = "idx_usage_pattern_bin", columnList = "bin_id"),
        @Index(name = "idx_usage_pattern_last_updated", columnList = "last_updated")
    }
)
public class UsagePatternModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Many models can exist per bin over time
     * Only the latest is used for prediction (service rule)
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bin_id", nullable = false)
    private Bin bin;

    @Column(name = "avg_daily_increase_weekday", nullable = false)
    private Double avgDailyIncreaseWeekday;

    @Column(name = "avg_daily_increase_weekend", nullable = false)
    private Double avgDailyIncreaseWeekend;

    @Column(name = "last_updated", nullable = false)
    private Timestamp lastUpdated;

    /*
     * Logical one-to-many
     * Ownership is on OverflowPrediction.modelUsed
     */
    @OneToMany(mappedBy = "modelUsed")
    private List<OverflowPrediction> overflowPredictions;

    // ---------- Constructors ----------

    public UsagePatternModel() {
        // required by JPA
    }

    public UsagePatternModel(
            Bin bin,
            Double avgDailyIncreaseWeekday,
            Double avgDailyIncreaseWeekend,
            Timestamp lastUpdated
    ) {
        this.bin = bin;
        this.avgDailyIncreaseWeekday = avgDailyIncreaseWeekday;
        this.avgDailyIncreaseWeekend = avgDailyIncreaseWeekend;
        this.lastUpdated = lastUpdated;
    }

    // ---------- Lifecycle hooks ----------

    @PrePersist
    protected void onCreate() {
        if (this.lastUpdated == null) {
            this.lastUpdated = new Timestamp(System.currentTimeMillis());
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdated = new Timestamp(System.currentTimeMillis());
    }

    // ---------- Getters & Setters ----------

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

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }
}

package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(
    name = "fill_level_records",
    indexes = {
        @Index(name = "idx_fill_record_bin", columnList = "bin_id"),
        @Index(name = "idx_fill_record_time", columnList = "recorded_at")
    }
)
public class FillLevelRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Many records per bin
     * Bin is the parent, but NOT owning the lifecycle
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bin_id", nullable = false)
    private Bin bin;

    @Column(name = "fill_percentage", nullable = false)
    private Double fillPercentage;

    @Column(name = "recorded_at", nullable = false)
    private Timestamp recordedAt;

    @Column(name = "is_weekend", nullable = false)
    private Boolean isWeekend;

    // ---------- Constructors ----------

    public FillLevelRecord() {
        // required by JPA
    }

    public FillLevelRecord(
            Bin bin,
            Double fillPercentage,
            Timestamp recordedAt,
            Boolean isWeekend
    ) {
        this.bin = bin;
        this.fillPercentage = fillPercentage;
        this.recordedAt = recordedAt;
        this.isWeekend = isWeekend;
    }

    // ---------- Lifecycle hooks ----------

    @PrePersist
    protected void onCreate() {
        /*
         * recordedAt is REQUIRED by spec and provided externally,
         * so we DO NOT auto-generate it here.
         *
         * But we defensively initialize isWeekend if missing.
         */
        if (this.isWeekend == null && this.recordedAt != null) {
            this.isWeekend = isWeekendFromTimestamp(this.recordedAt);
        }
    }

    // ---------- Utility (entity-local, no business rules) ----------

    private boolean isWeekendFromTimestamp(Timestamp timestamp) {
        return timestamp.toLocalDateTime()
                .getDayOfWeek()
                .getValue() >= 6; // 6 = Saturday, 7 = Sunday
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

    public Double getFillPercentage() {
        return fillPercentage;
    }

    public void setFillPercentage(Double fillPercentage) {
        this.fillPercentage = fillPercentage;
    }

    public Timestamp getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(Timestamp recordedAt) {
        this.recordedAt = recordedAt;
    }

    public Boolean getIsWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(Boolean isWeekend) {
        this.isWeekend = isWeekend;
    }
}

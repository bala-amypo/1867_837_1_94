package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fill_level_records")
public class FillLevelRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bin_id")
    private Bin bin;

    @Column(nullable = false)
    private Double fillPercentage;

    @Column(nullable = false)
    private LocalDateTime recordedAt;

    @Column(nullable = false)
    private Boolean isWeekend;

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

    public Double getFillPercentage() {
        return fillPercentage;
    }

    public void setFillPercentage(Double fillPercentage) {
        this.fillPercentage = fillPercentage;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    public Boolean getIsWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(Boolean isWeekend) {
        this.isWeekend = isWeekend;
    }
}

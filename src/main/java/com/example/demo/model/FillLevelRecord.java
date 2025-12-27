package com.example.demo.model;

import java.time.LocalDateTime;

public class FillLevelRecord {

    private Long id;
    private Bin bin;
    private double fillLevel;
    private LocalDateTime recordedAt;

    public FillLevelRecord() {
    }

    public FillLevelRecord(Long id, Bin bin, double fillLevel, LocalDateTime recordedAt) {
        this.id = id;
        this.bin = bin;
        this.fillLevel = fillLevel;
        this.recordedAt = recordedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bin getBin() {
        return bin;
    }

    public void setBin(Bin bin) {
        this.bin = bin;
    }

    public double getFillLevel() {
        return fillLevel;
    }

    public void setFillLevel(double fillLevel) {
        this.fillLevel = fillLevel;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }
}

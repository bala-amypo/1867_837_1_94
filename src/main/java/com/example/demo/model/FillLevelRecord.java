package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class FillLevelRecord {
    private Long id;
    private Bin bin;
    private Double fillPercentage;
    private Timestamp recordedAt;
    private Boolean isWeekend;
    
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
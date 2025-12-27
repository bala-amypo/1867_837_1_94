package com.example.demo.model;

import java.time.LocalDateTime;

public class OverflowPrediction {

    private Bin bin;
    private LocalDateTime predictedAt;
    private LocalDateTime overflowTime;

    public OverflowPrediction() {
    }

    public OverflowPrediction(Bin bin, LocalDateTime predictedAt, LocalDateTime overflowTime) {
        this.bin = bin;
        this.predictedAt = predictedAt;
        this.overflowTime = overflowTime;
    }

    public Bin getBin() {
        return bin;
    }

    public void setBin(Bin bin) {
        this.bin = bin;
    }

    public LocalDateTime getPredictedAt() {
        return predictedAt;
    }

    public void setPredictedAt(LocalDateTime predictedAt) {
        this.predictedAt = predictedAt;
    }

    public LocalDateTime getOverflowTime() {
        return overflowTime;
    }

    public void setOverflowTime(LocalDateTime overflowTime) {
        this.overflowTime = overflowTime;
    }
}

package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "overflow_predictions")
public class OverflowPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bin_id")
    private Bin bin;

    @Column(nullable = false)
    private LocalDate predictedFullDate;

    @Column(nullable = false)
    private Integer daysUntilFull;

    @ManyToOne(optional = false)
    @JoinColumn(name = "model_id")
    private UsagePatternModel modelUsed;

    @Column(nullable = false)
    private LocalDateTime generatedAt;

    @PrePersist
    protected void onCreate() {
        this.generatedAt = LocalDateTime.now();
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

    public LocalDate getPredictedFullDate() {
        return predictedFullDate;
    }

    public void setPredictedFullDate(LocalDate predictedFullDate) {
        this.predictedFullDate = predictedFullDate;
    }

    public Integer getDaysUntilFull() {
        return daysUntilFull;
    }

    public void setDaysUntilFull(Integer daysUntilFull) {
        this.daysUntilFull = daysUntilFull;
    }

    public UsagePatternModel getModelUsed() {
        return modelUsed;
    }

    public void setModelUsed(UsagePatternModel modelUsed) {
        this.modelUsed = modelUsed;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }
}

package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(
    name = "overflow_predictions",
    indexes = {
        @Index(name = "idx_overflow_bin", columnList = "bin_id"),
        @Index(name = "idx_overflow_generated_at", columnList = "generated_at")
    }
)
public class OverflowPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Many predictions can exist per bin over time
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bin_id", nullable = false)
    private Bin bin;

    @Column(name = "predicted_full_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date predictedFullDate;

    @Column(name = "days_until_full", nullable = false)
    private Integer daysUntilFull;

    /*
     * Model used to generate this prediction
     * Logical one-to-many from UsagePatternModel
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "model_used_id", nullable = false)
    private UsagePatternModel modelUsed;

    @Column(name = "generated_at", nullable = false, updatable = false)
    private Timestamp generatedAt;

    // ---------- Constructors ----------

    public OverflowPrediction() {
        // required by JPA
    }

    public OverflowPrediction(
            Bin bin,
            Date predictedFullDate,
            Integer daysUntilFull,
            UsagePatternModel modelUsed,
            Timestamp generatedAt
    ) {
        this.bin = bin;
        this.predictedFullDate = predictedFullDate;
        this.daysUntilFull = daysUntilFull;
        this.modelUsed = modelUsed;
        this.generatedAt = generatedAt;
    }

    // ---------- Lifecycle hooks ----------

    @PrePersist
    protected void onCreate() {
        /*
         * generatedAt must always be set at creation time
         * Spec explicitly requires this
         */
        if (this.generatedAt == null) {
            this.generatedAt = new Timestamp(System.currentTimeMillis());
        }
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

    public Date getPredictedFullDate() {
        return predictedFullDate;
    }

    public void setPredictedFullDate(Date predictedFullDate) {
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

    public Timestamp getGeneratedAt() {
        return generatedAt;
    }
}

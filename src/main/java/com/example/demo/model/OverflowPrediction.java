package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "overflow_predictions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OverflowPrediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate predictedFullDate;
    private Integer daysUntilFull;
    private LocalDateTime generatedAt;

    @ManyToOne
    @JoinColumn(name = "bin_id")
    private Bin bin;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private UsagePatternModel modelUsed;
}
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fill_level_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FillLevelRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double fillPercentage;
    private LocalDateTime recordedAt;
    private Boolean isWeekend;

    @ManyToOne
    @JoinColumn(name = "bin_id")
    private Bin bin;
}
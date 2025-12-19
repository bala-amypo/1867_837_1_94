package com.example.demo.repository;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OverflowPredictionRepository
        extends JpaRepository<OverflowPrediction, Long> {

    @Query("""
        SELECT op
        FROM OverflowPrediction op
        WHERE op.bin.zone = :zone
          AND op.generatedAt = (
              SELECT MAX(op2.generatedAt)
              FROM OverflowPrediction op2
              WHERE op2.bin = op.bin
          )
    """)
    List<OverflowPrediction> findLatestPredictionsForZone(
            @Param("zone") Zone zone
    );
}

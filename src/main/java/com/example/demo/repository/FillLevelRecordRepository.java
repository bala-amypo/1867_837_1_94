package com.example.demo.repository;

import com.example.demo.model.Bin;
import com.example.demo.model.FillLevelRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

public interface FillLevelRecordRepository extends JpaRepository<FillLevelRecord, Long> {
    List<FillLevelRecord> findByBinOrderByRecordedAtDesc(Bin bin);
    Optional<FillLevelRecord> findTop1ByBinOrderByRecordedAtDesc(Bin bin);
    List<FillLevelRecord> findByBinAndRecordedAtBetween(Bin bin, LocalDateTime start, LocalDateTime end);
}
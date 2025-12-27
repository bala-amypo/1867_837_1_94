package com.example.demo.service.impl;

import com.example.demo.model.Bin;
import com.example.demo.model.FillLevelRecord;
import com.example.demo.model.OverflowPrediction;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.service.OverflowPredictionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class OverflowPredictionServiceImpl implements OverflowPredictionService {

    private final BinRepository binRepository;
    private final FillLevelRecordRepository recordRepository;

    public OverflowPredictionServiceImpl(
            BinRepository binRepository,
            FillLevelRecordRepository recordRepository) {
        this.binRepository = binRepository;
        this.recordRepository = recordRepository;
    }

    @Override
    public OverflowPrediction predictOverflow(Long binId) {

        Bin bin = binRepository.findById(binId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Bin not found"));

        List<FillLevelRecord> records =
                recordRepository.findByBin(bin);

        if (records.isEmpty()) {
            throw new IllegalStateException("No fill level records");
        }

        // Get the latest record
        FillLevelRecord latest = records.stream()
                .max(Comparator.comparing(FillLevelRecord::getRecordedAt))
                .get();

        double currentFill = latest.getFillLevel();

        // Simple rule-based prediction:
        // if >= 80%, predict overflow in 1 hour, else 5 hours
        LocalDateTime predictedAt = LocalDateTime.now();
        LocalDateTime overflowTime =
                currentFill >= 80
                        ? predictedAt.plusHours(1)
                        : predictedAt.plusHours(5);

        return new OverflowPrediction(bin, predictedAt, overflowTime);
    }
}

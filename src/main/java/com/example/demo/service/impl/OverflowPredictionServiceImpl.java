package com.example.demo.service.impl;

import com.example.demo.model.Bin;
import com.example.demo.model.FillLevelRecord;
import com.example.demo.model.UsagePatternModel;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.repository.UsagePatternModelRepository;
import com.example.demo.service.OverflowPredictionService;
import org.springframework.stereotype.Service;

@Service
public class OverflowPredictionServiceImpl implements OverflowPredictionService {

    private final FillLevelRecordRepository recordRepository;
    private final UsagePatternModelRepository modelRepository;

    public OverflowPredictionServiceImpl(
            FillLevelRecordRepository recordRepository,
            UsagePatternModelRepository modelRepository) {
        this.recordRepository = recordRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public boolean predictOverflow(Bin bin) {

        FillLevelRecord record = recordRepository
                .findTop1ByBinOrderByRecordedAtDesc(bin)
                .orElse(null);

        UsagePatternModel model = modelRepository
                .findTop1ByBinOrderByLastUpdatedDesc(bin)
                .orElse(null);

        if (record == null || model == null) return false;

        return record.getFillLevel() + model.getDailyIncrease() >= 100;
    }
}

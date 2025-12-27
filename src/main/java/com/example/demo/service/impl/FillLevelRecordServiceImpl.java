package com.example.demo.service.impl;

import com.example.demo.model.Bin;
import com.example.confirmed.model.FillLevelRecord;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.service.FillLevelRecordService;
import org.springframework.stereotype.Service;

@Service
public class FillLevelRecordServiceImpl implements FillLevelRecordService {

    private final FillLevelRecordRepository recordRepository;

    public FillLevelRecordServiceImpl(FillLevelRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public FillLevelRecord getLatestRecord(Bin bin) {
        return recordRepository
                .findTop1ByBinOrderByRecordedAtDesc(bin)
                .orElse(null);
    }
}

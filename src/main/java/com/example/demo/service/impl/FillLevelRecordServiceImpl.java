package com.example.demo.service.impl;

import com.example.demo.model.Bin;
import com.example.demo.model.FillLevelRecord;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.service.FillLevelRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FillLevelRecordServiceImpl implements FillLevelRecordService {

    private final FillLevelRecordRepository recordRepository;

    public FillLevelRecordServiceImpl(FillLevelRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public List<FillLevelRecord> getRecentRecords(Long binId, int limit) {
        return recordRepository.findAll();
    }
}

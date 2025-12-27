package com.example.demo.service.impl;

import com.example.demo.model.FillLevelRecord;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.service.FillLevelRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FillLevelRecordServiceImpl implements FillLevelRecordService {

    private final FillLevelRecordRepository repository;

    public FillLevelRecordServiceImpl(FillLevelRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public FillLevelRecord getRecordById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<FillLevelRecord> getRecentRecords(Long binId, int limit) {
        return repository.findTopByBinIdOrderByRecordedAtDesc(binId, limit);
    }
}

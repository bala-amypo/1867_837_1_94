package com.example.demo.service.impl;

import com.example.demo.entity.Bin;
import com.example.demo.entity.FillLevelRecord;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.FillLevelRecordRepository;
import com.example.demo.service.FillLevelRecordService;

import java.sql.Timestamp;

public class FillLevelRecordServiceImpl implements FillLevelRecordService {

    private final FillLevelRecordRepository repository;

    public FillLevelRecordServiceImpl(FillLevelRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public FillLevelRecord createRecord(FillLevelRecord record) {
        Timestamp now = new Timestamp(System.currentTimeMillis());

        if (record.getRecordedAt().after(now)) {
            throw new BadRequestException("recordedAt must not be in the future");
        }

        if (!record.getBin().getActive()) {
            throw new BadRequestException("Bin must be active");
        }

        return repository.save(record);
    }
}

package com.example.demo.repository;

import com.example.demo.model.Bin;
import com.example.demo.model.FillLevelRecord;

import java.util.List;

public interface FillLevelRecordRepository {

    List<FillLevelRecord> findByBin(Bin bin);
}

package com.example.demo.repository;

import com.example.demo.model.Bin;
import com.example.demo.model.FillLevelRecord;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryFillLevelRecordRepository implements FillLevelRecordRepository {

    private final List<FillLevelRecord> records = new ArrayList<>();

    public InMemoryFillLevelRecordRepository() {
        Bin bin1 = new Bin(1L, 100.0);

        records.add(new FillLevelRecord(1L, bin1, 60.0, LocalDateTime.now().minusHours(2)));
        records.add(new FillLevelRecord(2L, bin1, 75.0, LocalDateTime.now().minusHours(1)));
        records.add(new FillLevelRecord(3L, bin1, 85.0, LocalDateTime.now()));
    }

    @Override
    public List<FillLevelRecord> findByBin(Bin bin) {
        List<FillLevelRecord> result = new ArrayList<>();
        for (FillLevelRecord record : records) {
            if (record.getBin().getId().equals(bin.getId())) {
                result.add(record);
            }
        }
        return result;
    }
}

package com.example.demo.controller;

import com.example.demo.model.FillLevelRecord;
import com.example.demo.service.impl.FillLevelRecordServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fill-records")
public class FillLevelRecordController {

    private final FillLevelRecordServiceImpl recordService;

    public FillLevelRecordController(FillLevelRecordServiceImpl recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public ResponseEntity<FillLevelRecord> createRecord(@RequestBody FillLevelRecord record) {
        return ResponseEntity.ok(recordService.createRecord(record));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FillLevelRecord> getRecordById(@PathVariable Long id) {
        return ResponseEntity.ok(recordService.getRecordById(id));
    }

    @GetMapping("/bin/{binId}")
    public ResponseEntity<List<FillLevelRecord>> getRecordsForBin(@PathVariable Long binId) {
        return ResponseEntity.ok(recordService.getRecentRecords(binId, 1000)); 
    }

    @GetMapping("/bin/{binId}/recent")
    public ResponseEntity<List<FillLevelRecord>> getRecentRecords(@PathVariable Long binId, 
                                                                  @RequestParam(defaultValue = "5") int limit) {
        return ResponseEntity.ok(recordService.getRecentRecords(binId, limit));
    }
}
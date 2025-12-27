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

    [cite_start]@PostMapping // [cite: 430]
    public ResponseEntity<FillLevelRecord> createRecord(@RequestBody FillLevelRecord record) {
        return ResponseEntity.ok(recordService.createRecord(record));
    }

    [cite_start]@GetMapping("/{id}") // [cite: 431]
    public ResponseEntity<FillLevelRecord> getRecordById(@PathVariable Long id) {
        return ResponseEntity.ok(recordService.getRecordById(id));
    }

    [cite_start]@GetMapping("/bin/{binId}") // [cite: 432]
    public ResponseEntity<List<FillLevelRecord>> getRecordsForBin(@PathVariable Long binId) {
        // Assuming you add this simple wrapper to Service if not present
        return ResponseEntity.ok(recordService.getRecentRecords(binId, 1000)); 
    }

    [cite_start]@GetMapping("/bin/{binId}/recent") // [cite: 433]
    public ResponseEntity<List<FillLevelRecord>> getRecentRecords(@PathVariable Long binId, 
                                                                  @RequestParam(defaultValue = "5") int limit) {
        return ResponseEntity.ok(recordService.getRecentRecords(binId, limit));
    }
}
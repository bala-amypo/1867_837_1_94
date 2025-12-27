package com.example.demo.controller;

import com.example.demo.model.UsagePatternModel;
import com.example.demo.service.impl.UsagePatternModelServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/models")
public class UsagePatternModelController {

    private final UsagePatternModelServiceImpl modelService;

    public UsagePatternModelController(UsagePatternModelServiceImpl modelService) {
        this.modelService = modelService;
    }

    [cite_start]@PostMapping // [cite: 436]
    public ResponseEntity<UsagePatternModel> createModel(@RequestBody UsagePatternModel model) {
        return ResponseEntity.ok(modelService.createModel(model));
    }

    [cite_start]@PutMapping("/{id}") // [cite: 437]
    public ResponseEntity<UsagePatternModel> updateModel(@PathVariable Long id, @RequestBody UsagePatternModel model) {
        return ResponseEntity.ok(modelService.updateModel(id, model));
    }

    [cite_start]@GetMapping("/bin/{binId}") // [cite: 438]
    public ResponseEntity<UsagePatternModel> getModelForBin(@PathVariable Long binId) {
        return ResponseEntity.ok(modelService.getModelForBin(binId));
    }
}
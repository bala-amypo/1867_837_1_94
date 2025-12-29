package com.example.demo.controller;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.service.impl.OverflowPredictionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/predictions")
public class OverflowPredictionController {

    private final OverflowPredictionServiceImpl predictionService;

    public OverflowPredictionController(OverflowPredictionServiceImpl predictionService) {
        this.predictionService = predictionService;
    }

    @PostMapping("/generate/{binId}")
    public ResponseEntity<OverflowPrediction> generatePrediction(@PathVariable Long binId) {
        return ResponseEntity.ok(predictionService.generatePrediction(binId));
    }

    @GetMapping("/zone/{zoneId}/latest")
    public ResponseEntity<List<OverflowPrediction>> getLatestPredictionsForZone(@PathVariable Long zoneId) {
        return ResponseEntity.ok(predictionService.getLatestPredictionsForZone(zoneId));
    }
}
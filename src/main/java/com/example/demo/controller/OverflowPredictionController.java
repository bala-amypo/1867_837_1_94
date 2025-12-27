package com.example.demo.controller;

import com.example.demo.model.OverflowPrediction;
import com.example.demo.service.OverflowPredictionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bins")
public class OverflowPredictionController {

    private final OverflowPredictionService predictionService;

    public OverflowPredictionController(OverflowPredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @GetMapping("/{binId}/overflow-prediction")
    public OverflowPrediction predictOverflow(@PathVariable Long binId) {
        return predictionService.predictOverflow(binId);
    }
}

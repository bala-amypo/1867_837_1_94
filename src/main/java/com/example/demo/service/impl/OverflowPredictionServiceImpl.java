package com.example.demo.service.impl;

import com.example.demo.service.OverflowPredictionService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OverflowPredictionServiceImpl implements OverflowPredictionService {

    @Override
    public List<String> getLatestPredictionsForZone(Long zoneId) {
        return Collections.emptyList();
    }
}

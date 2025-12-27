package com.example.demo.service;

import com.example.demo.model.UsagePatternModel;
import java.util.List;

public interface UsagePatternModelService {
    List<UsagePatternModel> getAllModels();
    UsagePatternModel getModelForBin(Long binId);
}

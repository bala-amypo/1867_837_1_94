package com.example.demo.service.impl;

import com.example.demo.model.UsagePatternModel;
import com.example.demo.repository.UsagePatternModelRepository;
import com.example.demo.service.UsagePatternModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsagePatternModelServiceImpl implements UsagePatternModelService {

    private final UsagePatternModelRepository repository;

    public UsagePatternModelServiceImpl(UsagePatternModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UsagePatternModel> getAllModels() {
        return repository.findAll();
    }

    @Override
    public UsagePatternModel getModelForBin(Long binId) {
        return repository.findTopByBinIdOrderByLastUpdatedDesc(binId)
                .orElse(null);
    }
}

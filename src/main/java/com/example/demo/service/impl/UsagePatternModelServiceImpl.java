package com.example.demo.service.impl;

import com.example.demo.model.Bin;
import com.example.demo.model.UsagePatternModel;
import com.example.demo.repository.UsagePatternModelRepository;
import com.example.demo.service.UsagePatternModelService;
import org.springframework.stereotype.Service;

@Service
public class UsagePatternModelServiceImpl implements UsagePatternModelService {

    private final UsagePatternModelRepository modelRepository;

    public UsagePatternModelServiceImpl(UsagePatternModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public UsagePatternModel getLatestModel(Bin bin) {
        return modelRepository
                .findTop1ByBinOrderByLastUpdatedDesc(bin)
                .orElse(null);
    }
}

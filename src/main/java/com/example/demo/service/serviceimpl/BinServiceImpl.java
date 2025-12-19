package com.example.demo.service.impl;

import com.example.demo.entity.Bin;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.BinRepository;
import com.example.demo.service.BinService;

public class BinServiceImpl implements BinService {

    private final BinRepository binRepository;

    public BinServiceImpl(BinRepository binRepository) {
        this.binRepository = binRepository;
    }

    @Override
    public Bin createBin(Bin bin) {
        if (bin.getCapacityLiters() == null || bin.getCapacityLiters() <= 0) {
            throw new BadRequestException("capacity must be greater than 0");
        }

        return binRepository.save(bin);
    }
}

package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Bin;
import com.example.demo.model.Zone;
import com.example.demo.repository.BinRepository;
import com.example.demo.repository.ZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinServiceImpl {

    private final BinRepository binRepository;
    private final ZoneRepository zoneRepository;

    public BinServiceImpl(BinRepository binRepository, ZoneRepository zoneRepository) {
        this.binRepository = binRepository;
        this.zoneRepository = zoneRepository;
    }

    public Bin createBin(Bin bin) {
        // Validation: Capacity
        if (bin.getCapacityLiters() == null || bin.getCapacityLiters() <= 0) {
            throw new BadRequestException("Invalid capacity");
        }
        
        // Validation: Zone Active
        Zone zone = zoneRepository.findById(bin.getZone().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));
        
        if (Boolean.FALSE.equals(zone.getActive())) {
            throw new BadRequestException("Zone is inactive");
        }

        // Default Active
        if (bin.getActive() == null) {
            bin.setActive(true);
        }
        
        bin.setZone(zone);
        return binRepository.save(bin);
    }

    public Bin updateBin(Long id, Bin update) {
        Bin bin = getBinById(id);
        if (update.getLocationDescription() != null) {
            bin.setLocationDescription(update.getLocationDescription());
        }
        return binRepository.save(bin);
    }

    public Bin getBinById(Long id) {
        return binRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bin not found with id: " + id));
    }

    public List<Bin> getAllBins() {
        return binRepository.findAll();
    }

    public void deactivateBin(Long id) {
        Bin bin = getBinById(id);
        bin.setActive(false);
        binRepository.save(bin);
    }
}
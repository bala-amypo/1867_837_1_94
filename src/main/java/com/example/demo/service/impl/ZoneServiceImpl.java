package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Zone;
import com.example.demo.repository.ZoneRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ZoneServiceImpl {

    private final ZoneRepository zoneRepository;

    public ZoneServiceImpl(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    public Zone createZone(Zone zone) {
        if (zone.getActive() == null) {
            zone.setActive(true);
        }
        return zoneRepository.save(zone);
    }

    public Zone getZoneById(Long id) {
        return zoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));
    }

    public Zone updateZone(Long id, Zone update) {
        Zone zone = getZoneById(id);
        if (update.getDescription() != null) {
            zone.setDescription(update.getDescription());
        }
        if (update.getZoneName() != null) {
            zone.setZoneName(update.getZoneName());
        }
        return zoneRepository.save(zone);
    }

    // This was the missing method causing your error
    public List<Zone> getAllZones() {
        return zoneRepository.findAll();
    }

    public void deactivateZone(Long id) {
        Zone zone = getZoneById(id);
        zone.setActive(false);
        zoneRepository.save(zone);
    }
}
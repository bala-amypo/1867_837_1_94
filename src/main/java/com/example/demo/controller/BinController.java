package com.example.demo.controller;

import com.example.demo.model.Bin;
import com.example.demo.service.impl.BinServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bins")
public class BinController {

    private final BinServiceImpl binService;

    public BinController(BinServiceImpl binService) {
        this.binService = binService;
    }

    [cite_start]@PostMapping // [cite: 423]
    public ResponseEntity<Bin> createBin(@RequestBody Bin bin) {
        return ResponseEntity.ok(binService.createBin(bin));
    }

    [cite_start]@PutMapping("/{id}") // [cite: 424]
    public ResponseEntity<Bin> updateBin(@PathVariable Long id, @RequestBody Bin bin) {
        return ResponseEntity.ok(binService.updateBin(id, bin));
    }

    [cite_start]@GetMapping("/{id}") // [cite: 425]
    public ResponseEntity<Bin> getBinById(@PathVariable Long id) {
        return ResponseEntity.ok(binService.getBinById(id));
    }

    [cite_start]@GetMapping // [cite: 426]
    public ResponseEntity<List<Bin>> getAllBins() {
        return ResponseEntity.ok(binService.getAllBins());
    }

    [cite_start]@PutMapping("/{id}/deactivate") // [cite: 427]
    public ResponseEntity<Void> deactivateBin(@PathVariable Long id) {
        binService.deactivateBin(id);
        return ResponseEntity.ok().build();
    }
}
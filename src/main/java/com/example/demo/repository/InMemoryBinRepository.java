package com.example.demo.repository;

import com.example.demo.model.Bin;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryBinRepository implements BinRepository {

    private final Map<Long, Bin> store = new HashMap<>();

    public InMemoryBinRepository() {
        // sample data
        store.put(1L, new Bin(1L, 100.0));
        store.put(2L, new Bin(2L, 200.0));
    }

    @Override
    public Optional<Bin> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
}

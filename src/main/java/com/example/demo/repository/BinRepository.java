package com.example.demo.repository;

import com.example.demo.model.Bin;

import java.util.Optional;

public interface BinRepository {

    Optional<Bin> findById(Long id);
}

package com.example.demo.model;

public class Bin {

    private Long id;
    private double capacity;

    public Bin() {
    }

    public Bin(Long id, double capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}

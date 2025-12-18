package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@entity
public class Bin {
    private long id ;
    private String identifier ;
    private String locationDescription ;
    private double latitude ;
    private double longtitude;
    private Zone zone ;
    private double capacityLiters ;
    private Boolean active ; 
    private Timestamp createdAt ;
    private Timestamp updatedAt ;

    public Bin( String Identifier , String locationDescription , Double latitude , Double longtitude ,
                Zone zone , Double capacityLiters , Boolean active , Timestamp createdAt , Timestamp updatedAt)
    {
        this.identifier = identifier;    
        this.locationDescription = locationdescription;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.zone = zone;
        this.capacityLiters = capacityLiters;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public Long getId()
    {
        return id ;
    }
    public String getIdentifier()
    {
        return identifier ;
    }
    public void setIdentifier( String identifier)
    {
        this.identifier = identifier ;
    }
     public String getLoactionDescription()
    {
        return locationDescription ;
    }
    public void setIdentifier( String identifier)
    {
        this.identifier = identifier ;
    }
    


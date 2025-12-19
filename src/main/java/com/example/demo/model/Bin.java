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
    public void setLocationDescription( String locationDescription)
    {
        this.locationDescription = locationDescription ;
    }
    public double getLatitude()
    {
        return latitude ;
    }
    public void setLatitude( Double latitude )
    {
        this.latitude = latitude ;
    }
      public double getLongtitude()
    {
        return longtitude ;
    }
    public void setLatitude( Double longtitude )
    {
        this.longtitude = longtitude  ;
    }
        public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Double getCapacityLiters() {
        return capacityLiters;
    }

    public void setCapacityLiters(Double capacityLiters) {
        this.capacityLiters = capacityLiters;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}

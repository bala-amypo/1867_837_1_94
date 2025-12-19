package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class UsagePatternModel {
   private Long id;
   private Bin bin;
   private Double avgDailyIncreaseWeekday;
   private Double avgDailyIncreaseWeekend;
   private Timestamp lastUpdated;
   
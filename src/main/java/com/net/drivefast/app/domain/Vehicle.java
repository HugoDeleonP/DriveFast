package com.net.drivefast.app.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)    
    private String brand;

    @Column(nullable = false)    
    private String model;

    @Column(name = "license_plate", nullable = false)
    private String licensePlate;

    @Column(name = "diary_value", nullable = false)    
    private BigDecimal diaryValue;

    @Column(nullable = false)
    private Boolean available;

    public Vehicle(String brand, String model, String licensePlate, BigDecimal diaryValue) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.diaryValue = diaryValue;
    }

    public Vehicle(BigDecimal diaryValue, Boolean available) {
        this.diaryValue = diaryValue;
        this.available = available;
    }
    
}

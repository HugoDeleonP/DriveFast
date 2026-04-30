package com.net.drivefast.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.net.drivefast.app.domain.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
    
    List<Vehicle> findByAvailable(Boolean available);
}

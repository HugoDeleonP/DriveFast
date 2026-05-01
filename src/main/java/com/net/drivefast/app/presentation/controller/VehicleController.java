package com.net.drivefast.app.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.net.drivefast.app.business.service.VehicleService;
import com.net.drivefast.app.presentation.dto.message.MessageDTO;
import com.net.drivefast.app.presentation.dto.vehicle.VehicleCreateDTO;
import com.net.drivefast.app.presentation.dto.vehicle.VehicleResponseDTO;
import com.net.drivefast.app.presentation.dto.vehicle.VehicleUpdateDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> save(VehicleCreateDTO dto){
        return ResponseEntity.status(HttpStatus.OK)
            .body(null);
    }

    @GetMapping
    public ResponseEntity<VehicleResponseDTO> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
            .body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK)
            .body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> updateById(@PathVariable("id") Long id, VehicleUpdateDTO dto){
        return ResponseEntity.status(HttpStatus.OK)
            .body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable("id") Long id ){
        return ResponseEntity.status(HttpStatus.OK)
            .body(null);
    }

    @GetMapping("/availables")
    public ResponseEntity<VehicleResponseDTO> findByAvailableTrue(){
        return ResponseEntity.status(HttpStatus.OK)
            .body(null);
    }
}

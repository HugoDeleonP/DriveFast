package com.net.drivefast.app.presentation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<VehicleResponseDTO> save(@RequestBody VehicleCreateDTO dto){
        return ResponseEntity.status(HttpStatus.OK)
            .body(vehicleService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
            .body(vehicleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK)
            .body(vehicleService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> updateById(@PathVariable("id") Long id, @RequestBody VehicleUpdateDTO dto){
        return ResponseEntity.status(HttpStatus.OK)
            .body(vehicleService.updateById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable("id") Long id ){
        return ResponseEntity.status(HttpStatus.OK)
            .body(vehicleService.deleteByID(id));
    }

    @GetMapping("/availables")
    public ResponseEntity<List<VehicleResponseDTO>> findByAvailableTrue(){
        return ResponseEntity.status(HttpStatus.OK)
            .body(vehicleService.findByAvailableTrue());
    }
}

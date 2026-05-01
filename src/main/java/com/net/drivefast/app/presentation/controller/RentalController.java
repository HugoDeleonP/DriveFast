package com.net.drivefast.app.presentation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.net.drivefast.app.business.service.RentalService;
import com.net.drivefast.app.presentation.dto.message.MessageDTO;
import com.net.drivefast.app.presentation.dto.rental.RentalCreateDTO;
import com.net.drivefast.app.presentation.dto.rental.RentalResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
public class RentalController {
    
    private final RentalService rentalService;

    @PostMapping
    public ResponseEntity<RentalResponseDTO> save(RentalCreateDTO dto){
        return ResponseEntity.status(HttpStatus.OK)
            .body(null);        
    }

    @GetMapping
    public ResponseEntity<List<RentalResponseDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
            .body(null);
    }

    @DeleteMapping
    public ResponseEntity<MessageDTO> deleteById(){
        return ResponseEntity.status(HttpStatus.OK)
            .body(null);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<RentalResponseDTO> searchAllByClientId(@PathVariable("clientId") Long clientId){
        return ResponseEntity.status(HttpStatus.OK)
            .body(null);
    }

}

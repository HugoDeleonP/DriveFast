package com.net.drivefast.app.presentation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.net.drivefast.app.business.service.ClientService;
import com.net.drivefast.app.persistence.projection.ClientCostProjection;
import com.net.drivefast.app.presentation.dto.client.ClientCreateDTO;
import com.net.drivefast.app.presentation.dto.client.ClientResponseDTO;
import com.net.drivefast.app.presentation.dto.client.ClientUpdateDTO;
import com.net.drivefast.app.presentation.dto.message.MessageDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    
    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientResponseDTO> save(ClientCreateDTO dto){
        return ResponseEntity.status(HttpStatus.OK)
            .body(null);
    }

    @GetMapping
    public ResponseEntity<ClientResponseDTO> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
            .body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK)
            .body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> updateById(@PathVariable("id") Long id, ClientUpdateDTO dto){
        return ResponseEntity.status(HttpStatus.OK)
            .body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable("id") Long id ){
        return ResponseEntity.status(HttpStatus.OK)
            .body(null);
    }

    @GetMapping("/report-costs")
    public ResponseEntity<List<ClientCostProjection>> reportCosts(){
        return ResponseEntity.status(HttpStatus.OK)
            .body(null);        
    }


}

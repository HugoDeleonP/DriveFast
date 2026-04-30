package com.net.drivefast.app.business.service;

import org.springframework.stereotype.Service;

import com.net.drivefast.app.business.mapper.ClientMapper;
import com.net.drivefast.app.persistence.repository.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
    
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    
}

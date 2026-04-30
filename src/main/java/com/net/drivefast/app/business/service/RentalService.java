package com.net.drivefast.app.business.service;

import org.springframework.stereotype.Service;

import com.net.drivefast.app.business.mapper.RentalMapper;
import com.net.drivefast.app.persistence.repository.RentalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RentalService {
    
    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;
}

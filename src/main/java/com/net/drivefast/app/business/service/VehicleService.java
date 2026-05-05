package com.net.drivefast.app.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.net.drivefast.app.business.mapper.VehicleMapper;
import com.net.drivefast.app.domain.Vehicle;
import com.net.drivefast.app.persistence.repository.VehicleRepository;
import com.net.drivefast.app.presentation.dto.vehicle.VehicleResponseDTO;
import com.net.drivefast.app.presentation.dto.vehicle.VehicleCreateDTO;
import com.net.drivefast.app.presentation.dto.vehicle.VehicleUpdateDTO;
import com.net.drivefast.app.presentation.dto.message.MessageDTO;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleService {
    
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public VehicleResponseDTO save(VehicleCreateDTO dto){

        Vehicle vehicle = vehicleMapper.toEntity(dto);
        vehicle.setAvailable(true);

        return vehicleMapper.toResponse(vehicleRepository.save(vehicle));
    }

    public List<VehicleResponseDTO> findAll(){
        return vehicleRepository.findAll().stream()
            .map(vehicle -> vehicleMapper.toResponse(vehicle))
            .toList();
    }

    public VehicleResponseDTO findById(Long id){

        Vehicle vehicleSearch = vehicleRepository.findById(id)
                                    .orElseThrow( () -> new RuntimeException("Veículo não encontrado"));

        return vehicleMapper.toResponse(vehicleSearch);
    } 

    public VehicleResponseDTO updateById(Long id, VehicleUpdateDTO dto){

        Vehicle vehicleSearch = vehicleRepository.findById(id)
                                    .orElseThrow( () -> new RuntimeException("Veículo não encontrado"));

        vehicleSearch.setDiaryValue(dto.diaryValue());
        vehicleSearch.setAvailable(dto.available());

        return vehicleMapper.toResponse(vehicleRepository.save(vehicleSearch));
    }

    public MessageDTO deleteByID(Long id){

        vehicleRepository.findById(id)
            .orElseThrow( () -> new RuntimeException("Veículo não encontrado"));

        vehicleRepository.deleteById(id);

        return new MessageDTO("Veículo deletado com sucesso!");
    }

    public List<VehicleResponseDTO> findByAvailableTrue(){

        List<Vehicle> vehiclesAvailableTrue = vehicleRepository.findByAvailableTrue();

        return vehiclesAvailableTrue.stream()
            .map(vehicle -> vehicleMapper.toResponse(vehicle))
            .toList();
    }

}

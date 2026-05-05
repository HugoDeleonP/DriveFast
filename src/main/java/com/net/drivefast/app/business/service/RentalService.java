package com.net.drivefast.app.business.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.net.drivefast.app.business.mapper.RentalMapper;
import com.net.drivefast.app.domain.Client;
import com.net.drivefast.app.domain.Rental;
import com.net.drivefast.app.domain.Vehicle;
import com.net.drivefast.app.persistence.repository.ClientRepository;
import com.net.drivefast.app.persistence.repository.RentalRepository;
import com.net.drivefast.app.persistence.repository.VehicleRepository;
import com.net.drivefast.app.presentation.dto.rental.RentalCreateDTO;
import com.net.drivefast.app.presentation.dto.rental.RentalResponseDTO;
import com.net.drivefast.app.presentation.dto.message.MessageDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RentalService {
    
    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;

    private final ClientRepository clientRepository;
    private final VehicleRepository vehicleRepository;

    public RentalResponseDTO save(RentalCreateDTO dto){

        Client client = clientRepository.findById(dto.clientId())
            .orElseThrow( () -> new RuntimeException("Cliente não encontrado"));

        Vehicle vehicle = vehicleRepository.findById(dto.vehicleId())
            .orElseThrow( () -> new RuntimeException("Veículo não encontrado"));

        vehicle.setAvailable(false);

        vehicleRepository.save(vehicle);

        Rental rental = rentalMapper.toEntity(dto);
        BigDecimal totalValue = vehicle.getDiaryValue().multiply(BigDecimal.valueOf(rental.getDays()));

        rental.setClient(client);
        rental.setVehicle(vehicle);
        rental.setTotalValue(totalValue);

        return rentalMapper.toResponse(rentalRepository.save(rental));
    }

    public List<RentalResponseDTO> findAll(){
        return rentalRepository.findAll().stream()
            .map(rental -> rentalMapper.toResponse(rental))
            .toList();
    }

    public MessageDTO deleteById(Long id){

        Rental rental = rentalRepository.findById(id)
            .orElseThrow( () -> new RuntimeException("Locação não encontrada"));

        Vehicle vehicleSearch = vehicleRepository.findById(rental.getVehicle().getId())
            .orElseThrow( () -> new RuntimeException("Veículo não encontrado"));

        vehicleSearch.setAvailable(true);
        vehicleRepository.save(vehicleSearch);

        rentalRepository.deleteById(id);

        return new MessageDTO("Locação deletada com sucesso");
    }

    public List<RentalResponseDTO> searchAllByClientId(Long clientId){

        List<Rental> rentals = rentalRepository.searchAllByClientId(clientId);

        return rentals.stream()
            .map(rental -> rentalMapper.toResponse(rental))
            .toList();
    }

}

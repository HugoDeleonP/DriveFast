package com.net.drivefast.app.business.mapper;

import org.springframework.stereotype.Component;

import com.net.drivefast.app.domain.Client;
import com.net.drivefast.app.presentation.dto.client.ClientCreateDTO;
import com.net.drivefast.app.presentation.dto.client.ClientResponseDTO;
import com.net.drivefast.app.presentation.dto.client.ClientUpdateDTO;

@Component
public class ClientMapper {

    public Client toEntity(ClientCreateDTO dto){
        return new Client(
            dto.name(),
            dto.cnh(),
            dto.email()
        );
    }

    public Client toEntity(ClientUpdateDTO dto){
        return new Client(
            dto.name(),
            dto.email()
        );
    }

    public ClientResponseDTO toResponseDTO(Client client){
        return new ClientResponseDTO(
            client.getId(),
            client.getName(),
            client.getCnh(),
            client.getEmail()
        );
    }
}

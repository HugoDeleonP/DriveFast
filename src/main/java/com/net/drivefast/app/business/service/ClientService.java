package com.net.drivefast.app.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.net.drivefast.app.business.mapper.ClientMapper;
import com.net.drivefast.app.domain.Client;
import com.net.drivefast.app.persistence.projection.ClientCostProjection;
import com.net.drivefast.app.persistence.repository.ClientRepository;
import com.net.drivefast.app.presentation.dto.client.ClientResponseDTO;
import com.net.drivefast.app.presentation.dto.client.ClientCostDTO;
import com.net.drivefast.app.presentation.dto.client.ClientCreateDTO;
import com.net.drivefast.app.presentation.dto.message.MessageDTO;
import com.net.drivefast.app.presentation.dto.client.ClientUpdateDTO;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
    
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientResponseDTO save(ClientCreateDTO dto){

        Client client = clientMapper.toEntity(dto);

        return clientMapper.toResponse(clientRepository.save(client));

    }

    public List<ClientResponseDTO> findAll(){

        List<Client> clients = clientRepository.findAll();

        return clients.stream()
            .map(clientMapper::toResponse)
            .toList();
    }

    public ClientResponseDTO findById(Long id){

        Client clientSearch = clientRepository.findById(id)
                            .orElseThrow( () -> new RuntimeException("Cliente não encontrado"));

        return clientMapper.toResponse(clientSearch);
    }

    public ClientResponseDTO updateById(Long id, ClientUpdateDTO dto){

        Client clientSearch = clientRepository.findById(id)
                            .orElseThrow( () -> new RuntimeException("Cliente não encontrado"));

        clientSearch.setName(dto.name());
        clientSearch.setEmail(dto.email());

        return clientMapper.toResponse(clientRepository.save(clientSearch));
    }

    public MessageDTO deleteById(Long id){

        clientRepository.findById(id)
            .orElseThrow( () -> new RuntimeException("Cliente não encontrado"));

        clientRepository.deleteById(id);

        return new MessageDTO("Cliente deletado com sucesso!");
    }

    public List<ClientCostDTO> reportCosts(){

        List<ClientCostProjection> projections = clientRepository.calculateCostByClient();

        List<ClientCostDTO> clientCostDTOs = projections.stream()
            .map(projection -> clientMapper.toResponseCosts(projection))
            .toList();


        return clientCostDTOs;
    }


}

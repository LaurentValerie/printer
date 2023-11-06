package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.entities.Client;
import ru.starcompany.printer.entities.ClientDto;
import ru.starcompany.printer.mappers.ClientDtoMapper;
import ru.starcompany.printer.repositories.ClientRepository;

@RequiredArgsConstructor
@Service
public class ClientPersistenceService {
    private final ClientRepository clientRepository;
    private final ClientDtoMapper clientDtoMapper;
    public ClientDto saveClient(Client client){
        return clientDtoMapper.toClientDto(clientRepository.save(client));
    }

}

package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.entities.Client;
import ru.starcompany.printer.dto.ClientDto;
import ru.starcompany.printer.mappers.ClientDtoMapper;
import ru.starcompany.printer.mappers.ClientMapper;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientMapper clientMapper;
    private final ClientDtoMapper clientDtoMapper;
    private final ClientPersistenceService clientPersistenceService;

    public ClientDto postClient(ClientDto clientDto){
        Client client = clientMapper.toClient(clientDto);
        return clientDtoMapper.toClientDto(clientPersistenceService.saveClient(client));
    }
}

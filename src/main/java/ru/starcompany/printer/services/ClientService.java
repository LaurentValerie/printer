package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.entities.Client;
import ru.starcompany.printer.dto.ClientDto;
import ru.starcompany.printer.mappers.ClientDto2ClientMapper;
import ru.starcompany.printer.mappers.Client2ClientDtoMapper;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final Client2ClientDtoMapper client2ClientDtoMapper;
    private final ClientDto2ClientMapper clientDto2ClientMapper;
    private final ClientPersistenceService clientPersistenceService;

    public ClientDto postClient(ClientDto clientDto){
        Client client = client2ClientDtoMapper.toClient(clientDto);
        return clientDto2ClientMapper.toClientDto(clientPersistenceService.saveClient(client));
    }
}

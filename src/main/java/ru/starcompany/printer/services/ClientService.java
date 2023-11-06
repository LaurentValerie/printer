package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.entities.ClientDto;
import ru.starcompany.printer.mappers.ClientMapper;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientMapper clientMapper;
    private final ClientPersistenceService clientPersistenceService;
    public ClientDto postClient(ClientDto clientDto){
        return clientPersistenceService.saveClient(clientMapper.toClient(clientDto));
    }
}

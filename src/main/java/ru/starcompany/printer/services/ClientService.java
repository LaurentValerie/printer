package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.dto.ClientDto;
import ru.starcompany.printer.entities.Client;
import ru.starcompany.printer.mappers.ClientMapper;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientMapper clientMapper;
    private final ClientPersistenceService clientPersistenceService;

    public ClientDto postClient(ClientDto clientDto){
        Client client = clientMapper.toClient(clientDto);
        return clientMapper.toClientDto(clientPersistenceService.saveClient(client));
    }

    public ClientDto getClient(String telegram) {
        return clientMapper.toClientDto(clientPersistenceService.findByTelegram(telegram));
    }

    public void deleteClient(String telegram) {
        clientPersistenceService.deleteClient(telegram);
    }

}

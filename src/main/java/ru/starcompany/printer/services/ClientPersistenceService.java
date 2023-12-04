package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.entities.Client;
import ru.starcompany.printer.repositories.ClientRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientPersistenceService {
    private final ClientRepository clientRepository;

    public Client saveClient(Client client){
        if (clientRepository.existsById(client.getUuid())) {
            log.info("Client: {} already exists", client.getUuid());
        }
        return clientRepository.save(client);
    }

}

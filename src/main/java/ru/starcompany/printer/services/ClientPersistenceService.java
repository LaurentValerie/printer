package ru.starcompany.printer.services;

import jakarta.persistence.EntityNotFoundException;
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

    public Client findByTelegram(String telegram) {
        return clientRepository.findById(telegram)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Client with telegram %s doesn't exists".formatted(telegram)));
    }

    public void deleteClient(String telegram) {
        if (!clientRepository.existsById(telegram)) {
            log.warn("Client UUID: {} doesn't exist", telegram);
            return;
        }
        clientRepository.deleteById(telegram);
    }

}

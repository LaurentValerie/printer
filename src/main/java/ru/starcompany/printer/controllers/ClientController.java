package ru.starcompany.printer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.starcompany.printer.entities.ClientDto;
import ru.starcompany.printer.services.ClientService;

@RestController
public class ClientController {
    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("/client/new")
    public ResponseEntity<Long> postClient(@RequestBody ClientDto clientDto){
        clientService.postClient(clientDto);
        return ResponseEntity.ok().body(clientDto.getId());
    }
}

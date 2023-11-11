package ru.starcompany.printer.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<Long> postClient(@RequestBody @Valid ClientDto clientDto){
        ClientDto savedClient = clientService.postClient(clientDto);
        return ResponseEntity.ok().body(savedClient.getId());
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Long> getClient(@PathVariable Long id){
        return ResponseEntity.ok().body(id);
    }
}

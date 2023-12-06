package ru.starcompany.printer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.starcompany.printer.dto.ClientDto;
import ru.starcompany.printer.services.ClientService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/client")
@Tag(name = "Client Controller", description = "Allows to create and get clients")
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/new")
    @Operation(summary = "Добавление нового клиента")
    public ResponseEntity<String> postClient(@RequestBody @Valid ClientDto clientDto){
        ClientDto savedClient = clientService.postClient(clientDto);
        return ResponseEntity.ok().body(savedClient.getTelegram());
    }

    @GetMapping("/{telegram}")
    @Operation(summary = "Получение клиента по его uuid (telegram)")
    public ResponseEntity<ClientDto> getClient(@PathVariable String telegram) {
        return ResponseEntity.ok().body(clientService.getClient(telegram));
    }

    @DeleteMapping("/{telegram}")
    @Operation(summary = "Удаление клиента по его uuid (telegram)")
    public ResponseEntity<?> deleteClient(@PathVariable String telegram) {
        clientService.deleteClient(telegram);
        return ResponseEntity.ok().build();
    }

}

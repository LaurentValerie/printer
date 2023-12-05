package ru.starcompany.printer.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.starcompany.printer.dto.ClientDto;
import ru.starcompany.printer.entities.Client;
import ru.starcompany.printer.mappers.ClientDtoMapper;
import ru.starcompany.printer.mappers.ClientMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {
    @Mock
    private ClientPersistenceService clientPersistenceService;
    private ClientService clientService;

    @BeforeEach
    void setUp() {
        var clientMapper = Mappers.getMapper(ClientMapper.class);
        var clientDtoMapper = Mappers.getMapper(ClientDtoMapper.class);
        clientService = new ClientService(clientMapper, clientDtoMapper, clientPersistenceService);
    }

    @Test
    void successfullySavingClientTest() {
        // given
        ClientDto clientDto = createClientDto();
        ArgumentCaptor<Client> argumentCaptor = ArgumentCaptor.forClass(Client.class);

        // when
        clientService.postClient(clientDto);

        // then
        verify(clientPersistenceService, times(1))
                .saveClient(argumentCaptor.capture());
        assertClients(clientDto, argumentCaptor.getValue());
    }

    private ClientDto createClientDto() {
        return ClientDto.builder()
                .telegram("TEST_SALLICHH")
                .name("TEST_REGINA")
                .build();
    }

    private void assertClients(ClientDto clientDto, Client client) {
        assertEquals(clientDto.getTelegram(), client.getUuid());
        assertEquals(clientDto.getName(), client.getName());
    }

}

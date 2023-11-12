package ru.starcompany.printer.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import ru.starcompany.printer.PrinterApplicationTests;
import ru.starcompany.printer.entities.Client;
import ru.starcompany.printer.entities.ClientDto;
import ru.starcompany.printer.repositories.ClientRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc(addFilters = false)
class ClientControllerIntegrationTest extends PrinterApplicationTests {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;


    @Test
    @DisplayName("POST /client/new создание клиента")
    public void successfullyCreateClientTest() throws Exception {
        // given
        ClientDto clientDto = createClientDto();

        // when
        ResultActions resultActions = mockMvc.perform(post("/client/new")
                        .content(mapper.writeValueAsString(clientDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());

        // then
        resultActions.andExpect(status().isOk());

        List<Client> clients = clientRepository.findAll();
        assertEquals(1, clients.size(), "Must be only one client");
        assertClients(clientDto, clients.get(0));
    }

    private ClientDto createClientDto() {
        return ClientDto.builder()
                .name("TEST_REGINA")
                .telegram("TEST_SALLICH")
                .build();
    }

    private void assertClients(ClientDto clientDto, Client client) {
        assertEquals(clientDto.getName(), client.getName());
        assertEquals(clientDto.getTelegram(), client.getTelegram());
    }
}

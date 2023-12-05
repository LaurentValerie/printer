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
import ru.starcompany.printer.dto.OrderDto;
import ru.starcompany.printer.entities.Order;
import ru.starcompany.printer.repositories.OrderRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
public class OrderControllerIntegrationTest extends PrinterApplicationTests {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @Test
    @DisplayName("POST /order/new создание заказа")
    public void successfullyCreateOrderTest() throws Exception {
        // given
        OrderDto orderDto = createOrderDto();

        // when
        ResultActions resultActions = mockMvc.perform(post("/order/new")
                        .content(mapper.writeValueAsString(orderDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());

        // then
        resultActions.andExpect(status().isOk());

        List<Order> orders = orderRepository.findAll();
        assertEquals(1, orders.size(), "Must be only one order");
        assertOrders(orderDto, orders.get(0));
    }

    private OrderDto createOrderDto() {
        return OrderDto.builder()
                .clientUuid("TEST_SALLICH")
                .executorUuid("TEST_SAMDEN28")
                .quantity(1)
                .plasticType("TEST_PETG")
                .plasticColour("TEST_BLACK")
                .information("TEST_INFO")
                .build();
    }

    private void assertOrders(OrderDto orderDto, Order order) {
        assertEquals(orderDto.getClientUuid(),order.getClientUuid());
        assertEquals(orderDto.getExecutorUuid(),order.getExecutorUuid());
        assertEquals(orderDto.getQuantity(),order.getQuantity());
        assertEquals(orderDto.getPlasticType(),order.getPlasticType());
        assertEquals(orderDto.getPlasticColour(),order.getPlasticColour());
        assertEquals(orderDto.getInformation(), order.getInformation());
    }

}

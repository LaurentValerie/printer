package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.entities.OrderDto;
import ru.starcompany.printer.mappers.OrderMapper;
import ru.starcompany.printer.controllers.WebClientController;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderPersistenceService orderPersistenceService;
    private final WebClientController controller;

    public OrderDto postOrder(OrderDto orderDto){
        OrderDto savedOrder = orderPersistenceService.saveOrder(orderMapper.toOrder(orderDto));
        controller.sendToExecutor(orderDto);
        orderDto.getPlasticColour().name();
        return savedOrder;
    }
}

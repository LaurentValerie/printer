package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.entities.OrderDto;
import ru.starcompany.printer.mappers.OrderMapper;
import ru.starcompany.printer.controllers.Controller;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderPersistenceService orderPersistenceService;
    private final Controller controller;
    public OrderDto postOrder(OrderDto orderDto){
        OrderDto orderDto1 = orderPersistenceService.saveOrder(orderMapper.toOrder(orderDto));
        controller.sendToExecutor(orderDto);
        return orderDto1;
    }
}
package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.dto.OrderDto;
import ru.starcompany.printer.entities.Order;
import ru.starcompany.printer.mappers.Order2OrderDtoMapper;
import ru.starcompany.printer.controllers.WebClientController;
import ru.starcompany.printer.mappers.OrderDto2OrderMapper;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final Order2OrderDtoMapper order2OrderDtoMapper;
    private final OrderDto2OrderMapper orderDto2OrderMapper;
    private final OrderPersistenceService orderPersistenceService;
    private final WebClientController webClientController;

    public OrderDto postOrder(OrderDto orderDto){
        Order savedOrder = orderPersistenceService.saveOrder(order2OrderDtoMapper.toOrder(orderDto));
        // TODO fix after complete front end
//        webClientController.sendToExecutor(orderDto);
        return orderDto2OrderMapper.toOrderDto(savedOrder);
    }
}

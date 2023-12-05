package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.dto.OrderDto;
import ru.starcompany.printer.mappers.OrderMapper;
import ru.starcompany.printer.controllers.WebClientController;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderPersistenceService orderPersistenceService;
    private final WebClientController webClientController;

    public OrderDto postOrder(OrderDto orderDto){
        OrderDto savedOrder = orderPersistenceService.saveOrder(orderMapper.toOrder(orderDto));
        // TODO fix after complete front end
//        webClientController.sendToExecutor(orderDto);
        return savedOrder;
    }
}

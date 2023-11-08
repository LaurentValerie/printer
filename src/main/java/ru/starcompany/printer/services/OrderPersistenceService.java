package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.entities.Order;
import ru.starcompany.printer.entities.OrderDto;
import ru.starcompany.printer.mappers.OrderDtoMapper;
import ru.starcompany.printer.repositories.OrderRepository;

@RequiredArgsConstructor
@Service
public class OrderPersistenceService {
    private final OrderRepository orderRepository;
    private final OrderDtoMapper orderDtoMapper;

    public OrderDto saveOrder(Order order){
        return orderDtoMapper.toOrderDto(orderRepository.save(order));
    }
}

package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.dto.ActiveOrderDto;
import ru.starcompany.printer.dto.NewOrderDto;
import ru.starcompany.printer.entities.Order;
import ru.starcompany.printer.entities.OrderStatus;
import ru.starcompany.printer.mappers.ActiveOrderMapper;
import ru.starcompany.printer.mappers.NewOrderMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final NewOrderMapper newOrderMapper;
    private final ActiveOrderMapper activeOrderMapper;
    private final OrderPersistenceService orderPersistenceService;

    public long saveNewOrder(NewOrderDto newOrderDto){
        Order newOrder = newOrderMapper.toOrder(newOrderDto);
        newOrder.setOrderStatus(OrderStatus.NEW);
        return orderPersistenceService.saveOrder(newOrder);
    }

    public List<NewOrderDto> getAllNewOrdersForExecutor(String executorUuid) {
        return orderPersistenceService.getAllNewOrdersForExecutor(executorUuid)
                .stream()
                .map(newOrderMapper::toOrderDto)
                .collect(Collectors.toList());
    }

    public List<ActiveOrderDto> getAllActiveOrdersForExecutor(String executorUuid) {
        return orderPersistenceService.getAllActiveOrdersForExecutor(executorUuid)
                .stream()
                .map(activeOrderMapper::toDto)
                .collect(Collectors.toList());
    }

    public long activateOrder(ActiveOrderDto activeOrderDto) {
        Order orderForUpdate = orderPersistenceService.getById(activeOrderDto.getId());
        Order updatedOrder = activeOrderMapper.partialUpdate(activeOrderDto, orderForUpdate);
        updatedOrder.setOrderStatus(OrderStatus.ACTIVE);
        return orderPersistenceService.saveOrder(updatedOrder);
    }

    public void finishOrder(Long orderId) {
        Order order = orderPersistenceService.getById(orderId);
        order.setOrderStatus(OrderStatus.DONE);
        orderPersistenceService.saveOrder(order);
    }

}

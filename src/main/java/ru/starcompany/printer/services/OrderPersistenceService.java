package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.entities.Order;
import ru.starcompany.printer.entities.OrderStatus;
import ru.starcompany.printer.repositories.OrderRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderPersistenceService {
    private final OrderRepository orderRepository;

    public Long saveOrder(Order order){
        return orderRepository.save(order).getId();
    }

    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> {
            log.warn("Order with id {} not found", id);
            return new RuntimeException();
        });
    }

    public List<Order> getAllNewOrdersForExecutor(String executorId) {
        return orderRepository.findAllByExecutorUuidAndOrderStatus(executorId, OrderStatus.NEW);
    }

    public List<Order> getAllActiveOrdersForExecutor(String executorId) {
        return orderRepository.findAllByExecutorUuidAndOrderStatus(executorId, OrderStatus.ACTIVE);
    }

}

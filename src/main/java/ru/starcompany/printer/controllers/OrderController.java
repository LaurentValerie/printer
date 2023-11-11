package ru.starcompany.printer.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.starcompany.printer.entities.OrderDto;
import ru.starcompany.printer.services.OrderService;

@RestController
public class OrderController {
    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/new")
    public ResponseEntity<Long> postOrder(@RequestBody @Valid OrderDto orderDto){
        OrderDto savedOrder = orderService.postOrder(orderDto);
        return ResponseEntity.ok().body(savedOrder.getId());
    }
}

package ru.starcompany.printer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.starcompany.printer.dto.OrderDto;
import ru.starcompany.printer.services.OrderService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order")
@Tag(name = "Order Controller", description = "Allows to create and get orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/new")
    @Operation(summary = "Добавление нового заказа")
    public ResponseEntity<Long> postOrder(@RequestBody @Valid OrderDto orderDto){
        OrderDto savedOrder = orderService.postOrder(orderDto);
        return ResponseEntity.ok().body(savedOrder.getId());
    }

}

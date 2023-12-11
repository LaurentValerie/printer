package ru.starcompany.printer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.starcompany.printer.dto.ActiveOrderDto;
import ru.starcompany.printer.dto.NewOrderDto;
import ru.starcompany.printer.services.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order")
@Tag(name = "Order Controller", description = "Allows to create and get orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/new")
    @Operation(summary = "Добавление нового заказа")
    public ResponseEntity<Long> postOrder(@RequestBody @Valid NewOrderDto newOrderDto){
        return ResponseEntity.ok().body(orderService.saveNewOrder(newOrderDto));
    }

    @PostMapping("/activate")
    @Operation(summary = "Сохранение оффера с обновленной исполнителем информацией и его перевд в активный статус")
    public ResponseEntity<Long> updateOrder(@RequestBody @Valid ActiveOrderDto activeOrderDto){
        return ResponseEntity.ok().body(orderService.activateOrder(activeOrderDto));
    }

    @PostMapping("/finish/{orderId}")
    @Operation(summary = "Перевод заказа в статус выполнен")
    public ResponseEntity<Long> finishOrder(@PathVariable Long orderId){
        orderService.finishOrder(orderId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/new/all/{executorUuid}")
    @Operation(summary = "Получение исполнителем всех новых заказов")
    public ResponseEntity<List<NewOrderDto>> getAllNewOrdersForExecutor(@PathVariable String executorUuid) {
        return ResponseEntity.ok().body(orderService.getAllNewOrdersForExecutor(executorUuid));
    }

    @GetMapping("/active/all/{executorUuid}")
    @Operation(summary = "Получение исполнителем всех активных заказов")
    public ResponseEntity<List<ActiveOrderDto>> getAllActiveOrdersForExecutor(@PathVariable String executorUuid) {
        return ResponseEntity.ok().body(orderService.getAllActiveOrdersForExecutor(executorUuid));
    }

}

package ru.starcompany.printer.controllers;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.starcompany.printer.entities.OrderDto;

@org.springframework.stereotype.Controller
public class WebClientController {
    WebClient webClient = WebClient.create("http://localhost:8080");

    public Mono<OrderDto> sendToExecutor(final OrderDto orderDto) {
        Mono<OrderDto> postMono = Mono.just(orderDto);
        return webClient
                .post()
                .body(postMono,OrderDto.class)
                .retrieve()
                .bodyToMono(OrderDto.class);
    }
}

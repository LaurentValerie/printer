package ru.starcompany.printer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.starcompany.printer.dto.OrderDto;

@Controller
public class WebClientController {
    WebClient webClient = WebClient.create("http://localhost:8090");

    public Mono<OrderDto> sendToExecutor(final OrderDto orderDto) {
        Mono<OrderDto> postMono = Mono.just(orderDto);
        return webClient
                .post()
                .body(postMono,OrderDto.class)
                .retrieve()
                .bodyToMono(OrderDto.class);
    }
}

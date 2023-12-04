package ru.starcompany.printer.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderDto {
    private long id;
    @NotEmpty
    private String clientUuid;
    @NotEmpty
    private String executorUuid;
    @NotNull
    private Integer quantity;
    @NotEmpty
    private String plasticType;
    @NotEmpty
    private String plasticColour;
    private String information;
}
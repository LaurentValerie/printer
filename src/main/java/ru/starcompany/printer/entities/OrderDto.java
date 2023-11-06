package ru.starcompany.printer.entities;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderDto {
    private long id;
    @NotNull
    private long clientId;
    @NotNull
    private long executorId;
    @NotEmpty
    private String name;
    @NotNull
    private int quantity;
    @NotEmpty
    private String plasticType;
    @NotEmpty
    private String plasticColor;
}

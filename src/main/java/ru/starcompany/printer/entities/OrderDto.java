package ru.starcompany.printer.entities;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @NotNull
    @Enumerated(EnumType.STRING)
    private PlasticType plasticType;
    @NotNull
    @Enumerated(EnumType.STRING)
    private PlasticColour plasticColour;
}

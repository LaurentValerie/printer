package ru.starcompany.printer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * DTO for {@link ru.starcompany.printer.entities.Order}
 */
@Getter
@Builder
@AllArgsConstructor
public class ActiveOrderDto {
    private final long id;
    @NotBlank
    private final String clientUuid;
    @NotBlank
    private final String executorUuid;
    @NotNull
    @Positive
    private final Integer quantity;
    @NotBlank
    private final String plasticType;
    @NotBlank
    private final String plasticColour;
    private final String information;
    @NotNull
    private final Long printingTime;
    @NotNull
    private final BigDecimal plasticWeight;
    @NotNull
    private final BigDecimal calcWeight;
    @NotNull
    private final BigDecimal threadLength;
}

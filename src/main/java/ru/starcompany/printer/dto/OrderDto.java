package ru.starcompany.printer.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
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

package ru.starcompany.printer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewOrderDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
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

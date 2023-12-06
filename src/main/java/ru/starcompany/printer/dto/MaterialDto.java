package ru.starcompany.printer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MaterialDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private long id;
    @NotEmpty
    private String materialType;
    private String materialTypeDesc;
    @NotEmpty
    private String materialColour;
    @NotNull
    private Integer spools;
    @NotNull
    private BigDecimal priceOriginal;
    @NotNull
    private BigDecimal currentPrice;
    @NotNull
    private BigDecimal weight;
    @NotNull
    private BigDecimal density;
    @NotNull
    private BigDecimal pricePerKgOriginal;
    @NotNull
    private BigDecimal pricePerKgCurrent;
    @NotNull
    private BigDecimal total;
    @NotNull
    private BigDecimal remaining;
    @NotEmpty
    private String spoolName;
    @NotNull
    private Integer remainingSpools;
    @NotNull
    private boolean isMeasurementsRequired;
    private int initialWeight;
}

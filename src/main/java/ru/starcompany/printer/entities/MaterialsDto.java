package ru.starcompany.printer.entities;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class MaterialsDto {
    private long id;
    @NotEmpty
    private String materialName;
    @NotNull
    private int spools;
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
    private int remainingSpools;
    @NotNull
    private boolean isMeasurementsRequired;
    private int initialWeight;
}

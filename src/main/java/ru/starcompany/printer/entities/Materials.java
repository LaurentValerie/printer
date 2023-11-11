package ru.starcompany.printer.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Entity
@Table(name = "materials")
public class Materials{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String materialName;
    private int spools;
    private BigDecimal priceOriginal;
    private BigDecimal currentPrice;
    private BigDecimal weight;
    private BigDecimal density;
    private BigDecimal pricePerKgOriginal;
    private BigDecimal pricePerKgCurrent;
    private BigDecimal total;
    private BigDecimal remaining;
    private String spoolName;
    private int remainingSpools;
    private boolean isMeasurementsRequired;
    private int initialWeight;

}

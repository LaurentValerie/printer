package ru.starcompany.printer.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "materials")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String materialType;
    private String materialTypeDesc;
    private String materialColour;
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

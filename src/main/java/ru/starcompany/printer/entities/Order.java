package ru.starcompany.printer.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String clientUuid;
    private String executorUuid;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private Integer quantity;
    private String plasticType;
    private String plasticColour;
    private String information;
    private Long printingTime;
    private BigDecimal plasticWeight;
    private BigDecimal calcWeight;
    private BigDecimal threadLength;
}

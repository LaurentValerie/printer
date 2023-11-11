package ru.starcompany.printer.entities;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long clientId;
    private long executorId;
    private String name;
    private int quantity;
    private PlasticType plasticType;
    private PlasticColour plasticColour;

}

package ru.starcompany.printer.entities;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDto {
    private long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String telegram;
}

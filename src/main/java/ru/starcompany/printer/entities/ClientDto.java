package ru.starcompany.printer.entities;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ClientDto {
    private long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String telegram;
}

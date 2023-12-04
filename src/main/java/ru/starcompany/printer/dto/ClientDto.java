package ru.starcompany.printer.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ClientDto {
    @NotEmpty
    private String telegram;
    @NotEmpty
    private String name;
}

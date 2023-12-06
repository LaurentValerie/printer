package ru.starcompany.printer.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
    @NotEmpty
    private String telegram;
    @NotEmpty
    private String name;
    private String phone;
}

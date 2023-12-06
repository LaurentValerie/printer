package ru.starcompany.printer.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MaterialTypeDto {
    private String materialType;
    private String materialTypeDesc;
}

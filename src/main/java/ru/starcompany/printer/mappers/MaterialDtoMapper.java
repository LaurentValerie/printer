package ru.starcompany.printer.mappers;


import org.mapstruct.Mapper;
import ru.starcompany.printer.entities.Material;
import ru.starcompany.printer.entities.MaterialDto;

@Mapper(componentModel = "spring")
public interface MaterialDtoMapper {
    MaterialDto toMaterialsDto(Material material);
}

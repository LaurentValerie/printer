package ru.starcompany.printer.mappers;

import org.mapstruct.Mapper;
import ru.starcompany.printer.entities.Material;
import ru.starcompany.printer.dto.MaterialDto;

@Mapper(componentModel = "spring")
public interface MaterialMapper {
    Material toMaterials(MaterialDto materialDto);
}

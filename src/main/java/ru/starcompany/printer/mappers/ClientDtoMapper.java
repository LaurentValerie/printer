package ru.starcompany.printer.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.starcompany.printer.entities.Client;
import ru.starcompany.printer.dto.ClientDto;

@Mapper(componentModel = "spring")
public interface ClientDtoMapper {
    @Mapping(target = "telegram", source = "uuid")
    ClientDto toClientDto(Client client);
}

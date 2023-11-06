package ru.starcompany.printer.mappers;

import org.mapstruct.Mapper;
import ru.starcompany.printer.entities.Client;
import ru.starcompany.printer.entities.ClientDto;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toClient(ClientDto clientDto);
}

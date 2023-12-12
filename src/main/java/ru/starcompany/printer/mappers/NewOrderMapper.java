package ru.starcompany.printer.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.starcompany.printer.dto.NewOrderDto;
import ru.starcompany.printer.entities.Order;

@Mapper(componentModel = "spring")
public interface NewOrderMapper {
    @Mapping(target = "orderStatus", ignore = true)
    Order toOrder(NewOrderDto newOrderDto);

    NewOrderDto toOrderDto(Order order);

}

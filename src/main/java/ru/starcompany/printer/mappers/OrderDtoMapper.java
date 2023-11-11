package ru.starcompany.printer.mappers;

import org.mapstruct.Mapper;
import ru.starcompany.printer.entities.Order;
import ru.starcompany.printer.entities.OrderDto;

@Mapper(componentModel = "spring")
public interface OrderDtoMapper {
    OrderDto toOrderDto(Order order);
}

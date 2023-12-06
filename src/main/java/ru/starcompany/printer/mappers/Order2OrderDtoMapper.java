package ru.starcompany.printer.mappers;

import org.mapstruct.Mapper;
import ru.starcompany.printer.entities.Order;
import ru.starcompany.printer.dto.OrderDto;

@Mapper(componentModel = "spring")
public interface Order2OrderDtoMapper {
    Order toOrder(OrderDto orderDto);
}

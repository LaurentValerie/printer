package ru.starcompany.printer.mappers;

import org.mapstruct.*;
import ru.starcompany.printer.dto.ActiveOrderDto;
import ru.starcompany.printer.entities.Order;

@Mapper(componentModel = "spring")
public interface ActiveOrderMapper {
    @Mapping(target = "orderStatus", ignore = true)
    Order toEntity(ActiveOrderDto activeOrderDto);

    ActiveOrderDto toDto(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order partialUpdate(ActiveOrderDto activeOrderDto, @MappingTarget Order order);
}

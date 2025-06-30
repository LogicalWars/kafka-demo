package ru.netology.creditapplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.netology.creditapplication.dto.event.CreditCreateEvent;
import ru.netology.creditapplication.entity.Credit;

@Mapper(componentModel = "spring")
public interface CreditEventMapper {
    CreditEventMapper INSTANCE = Mappers.getMapper(CreditEventMapper.class);

    CreditCreateEvent toEvent(Credit credit);
}

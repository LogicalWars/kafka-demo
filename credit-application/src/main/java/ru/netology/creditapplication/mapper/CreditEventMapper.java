package ru.netology.creditapplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.netology.creditapplication.entity.Credit;

@Mapper(componentModel = "spring")
public interface CreditEventMapper {
    CreditEventMapper INSTANCE = Mappers.getMapper(CreditEventMapper.class);

    @Mapping(target = "createdAt", ignore = true)
    CreditEventMapper toEvent(Credit credit);
}

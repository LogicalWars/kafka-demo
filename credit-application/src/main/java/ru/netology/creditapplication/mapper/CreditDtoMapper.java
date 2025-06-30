package ru.netology.creditapplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.netology.creditapplication.dto.request.CreditRequest;
import ru.netology.creditapplication.entity.Credit;

@Mapper(componentModel = "spring")
public interface CreditDtoMapper {
    CreditDtoMapper INSTANCE = Mappers.getMapper(CreditDtoMapper.class);

    Credit toEntity(CreditRequest dto);
}

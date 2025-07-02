package ru.netology.creditapplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.netology.creditapplication.dto.CreditResponse;
import ru.netology.creditapplication.entity.Credit;
import ru.netology.creditapplication.dto.CreditRequest;

@Mapper(componentModel = "spring")
public interface CreditDtoMapper {
    CreditDtoMapper INSTANCE = Mappers.getMapper(CreditDtoMapper.class);

    Credit toEntity(CreditRequest dto);
    CreditResponse toDto(Credit entity);
}

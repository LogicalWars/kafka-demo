package ru.netology.creditapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.creditapplication.dto.request.CreditRequest;
import ru.netology.creditapplication.mapper.CreditDtoMapper;
import ru.netology.creditapplication.repository.CreditRepository;

@Service
@RequiredArgsConstructor
public class CreditService {
    private final CreditRepository creditRepository;
    private final CreditDtoMapper creditDtoMapper;

    public Long createCredit(CreditRequest creditRequest) {
        return creditRepository.save(creditDtoMapper.toEntity(creditRequest)).getId();
    }
}

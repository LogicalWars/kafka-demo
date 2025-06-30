package ru.netology.creditapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.creditapplication.repository.CreditRepository;
import ru.netology.creditapplication.entity.Credit;

@Service
@RequiredArgsConstructor
public class CreditService {
    private final CreditRepository creditRepository;

    public Long createCredit(Credit credit) {
        return creditRepository.save(credit).getId();
    }
}

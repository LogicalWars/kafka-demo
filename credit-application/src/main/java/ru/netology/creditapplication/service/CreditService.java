package ru.netology.creditapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.CreditStatus;
import ru.netology.creditapplication.dto.CreditResponse;
import ru.netology.creditapplication.entity.Credit;
import ru.netology.creditapplication.mapper.CreditDtoMapper;
import ru.netology.creditapplication.mapper.CreditEventMapper;
import ru.netology.creditapplication.repository.CreditRepository;
import ru.netology.creditapplication.service.kafka.CreditEventProducer;
import ru.netology.event.CreditCreateEvent;
import ru.netology.creditapplication.dto.CreditRequest;
import ru.netology.event.CreditDecisionEvent;

@Service
@RequiredArgsConstructor
public class CreditService {
    private final CreditRepository creditRepository;
    private final CreditDtoMapper creditDtoMapper;
    private final CreditEventMapper creditEventMapper;
    private final CreditEventProducer creditEventProducer;

    public Long createCredit(CreditRequest creditRequest) {
        Credit credit = creditDtoMapper.toEntity(creditRequest);
        Long id = creditRepository.save(credit).getId();
        CreditCreateEvent creditCreateEvent = creditEventMapper.toEvent(credit);
        creditCreateEvent.setId(id);
        creditCreateEvent.setCreditStatus(CreditStatus.PENDING);
        creditEventProducer.send(creditCreateEvent);
        return id;
    }

    public CreditResponse getCredit(Long id) {
        return creditDtoMapper.toDto(creditRepository.findById(id).get());
    }

    @Transactional
    public void addCreditDecision(CreditDecisionEvent event) {
        creditRepository.updateCreditDecision(event.getId(), event.getCreditStatus());
    }
}

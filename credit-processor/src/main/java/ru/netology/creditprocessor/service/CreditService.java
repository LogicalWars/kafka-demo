package ru.netology.creditprocessor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.CreditStatus;
import ru.netology.creditprocessor.service.rabbit.CreditDecisionSender;
import ru.netology.event.CreditCreateEvent;
import ru.netology.event.CreditDecisionEvent;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class CreditService {
    private final CreditDecisionSender creditDecisionSender;

    public void processCredit(CreditCreateEvent event) {
        CreditDecisionEvent creditDecisionEvent = CreditDecisionEvent.builder()
                .creditStatus(CreditStatus.APPROVED)
                .id(event.getId())
                .build();

        if (event.getMonthlyIncome().divide(new BigDecimal("2"), 2, RoundingMode.HALF_UP)
                .compareTo(event.getLoanPayments()) < 0) {
            creditDecisionEvent.setCreditStatus(CreditStatus.REJECTED);
        }
        creditDecisionSender.send(creditDecisionEvent);
    }
}

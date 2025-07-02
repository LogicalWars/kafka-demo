package ru.netology.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.CreditStatus;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCreateEvent {
    private Long id;
    private BigDecimal amount;
    private Integer termMonth;
    private BigDecimal monthlyIncome;
    private BigDecimal loanPayments;
    private Integer creditScore;
    private CreditStatus creditStatus;
}

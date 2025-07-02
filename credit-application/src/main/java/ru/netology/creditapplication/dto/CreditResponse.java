package ru.netology.creditapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.CreditStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreditResponse {
    private Long id;
    private BigDecimal amount;
    private Integer termMonth;
    private BigDecimal monthlyIncome;
    private BigDecimal loanPayments;
    private Integer creditScore;
    private LocalDateTime createdAt;
    private CreditStatus status;
}

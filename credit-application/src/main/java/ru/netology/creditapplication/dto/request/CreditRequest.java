package ru.netology.creditapplication.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CreditRequest {
    private BigDecimal amount;
    private Integer termMonth;
    private BigDecimal monthlyIncome;
    private BigDecimal loanPayments;
    private Integer creditScore;
}

package ru.netology.creditapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "credits")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private Integer termMonth;

    @Column(nullable = false)
    private BigDecimal monthlyIncome;

    @Column(nullable = false)
    private BigDecimal loanPayments;

    @Column(nullable = false)
    private Integer creditScore;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private CreditStatus status;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.status = CreditStatus.PENDING;
    }
}

package ru.netology.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.CreditStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditDecisionEvent {
    private Long id;
    private CreditStatus creditStatus;
}

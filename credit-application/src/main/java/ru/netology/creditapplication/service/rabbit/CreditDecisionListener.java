package ru.netology.creditapplication.service.rabbit;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.netology.creditapplication.service.CreditService;
import ru.netology.event.CreditDecisionEvent;

@Component
@RequiredArgsConstructor
public class CreditDecisionListener {

    private final CreditService creditService;

    @RabbitListener(queues = "${app.rabbitmq.queue.credit-decision}")
    public void receive(CreditDecisionEvent event) {
        creditService.addCreditDecision(event);
    }
}

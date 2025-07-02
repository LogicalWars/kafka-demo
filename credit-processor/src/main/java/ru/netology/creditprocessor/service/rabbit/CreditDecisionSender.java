package ru.netology.creditprocessor.service.rabbit;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.netology.event.CreditDecisionEvent;

@Service
@RequiredArgsConstructor
public class CreditDecisionSender {

    @Value("${app.rabbitmq.queue.credit-decision}")
    private String creditDecisionQueue;

    private final RabbitTemplate rabbitTemplate;

    public void send(CreditDecisionEvent event) {
        rabbitTemplate.convertAndSend(creditDecisionQueue, event);
    }
}

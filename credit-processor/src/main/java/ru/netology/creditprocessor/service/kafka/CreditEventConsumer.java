package ru.netology.creditprocessor.service.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.netology.creditprocessor.service.CreditService;
import ru.netology.event.CreditCreateEvent;

@Component
@RequiredArgsConstructor
public class CreditEventConsumer {
    private final CreditService creditService;

    @KafkaListener(topics = "${app.kafka.consumer.topic.credit-create}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(CreditCreateEvent event) {
        creditService.processCredit(event);
    }
}

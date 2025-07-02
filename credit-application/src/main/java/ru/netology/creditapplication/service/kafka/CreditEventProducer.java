package ru.netology.creditapplication.service.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.netology.event.CreditCreateEvent;

@Service
@RequiredArgsConstructor
public class CreditEventProducer {

    @Value("${app.kafka.producer.topic.credit-create}")
    private String creditCreateTopic;

    private final KafkaTemplate<String, CreditCreateEvent> template;

    public void send(CreditCreateEvent event) {
        template.send(creditCreateTopic, event);
    }
}

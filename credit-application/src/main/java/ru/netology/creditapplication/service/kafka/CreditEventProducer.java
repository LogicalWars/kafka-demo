package ru.netology.creditapplication.service.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.netology.creditapplication.dto.event.CreditCreateEvent;

@Service
public class CreditEventProducer {

    @Value("${app.kafka.producer.topic.credit-create}")
    private String creditCreateTopic;

    private final KafkaTemplate<String, CreditCreateEvent> template;

    public CreditEventProducer(KafkaTemplate<String, CreditCreateEvent> template) {
        this.template = template;
    }

    public void send(CreditCreateEvent event) {
        template.send(creditCreateTopic, event.getId().toString(), event);
    }
}

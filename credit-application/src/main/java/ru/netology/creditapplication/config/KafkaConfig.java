package ru.netology.creditapplication.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Value("${app.kafka.producer.topic.credit-create}")
    private String creditCreateTopic;

    @Bean
    public NewTopic creditCreateTopic() {
        return TopicBuilder.name(creditCreateTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }

}

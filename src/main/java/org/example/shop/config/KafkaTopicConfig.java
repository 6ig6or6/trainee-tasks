package org.example.shop.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic confirmOrderTopic() {
        return TopicBuilder.name("confirm-order-topic").build();
    }

    @Bean
    public NewTopic deleteOrderTopic() {
        return TopicBuilder.name("delete-order-topic").build();
    }
}

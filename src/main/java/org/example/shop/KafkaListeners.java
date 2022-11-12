package org.example.shop;

import org.example.shop.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class KafkaListeners {
    private static final Logger logger = LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(topics = "delete-order-topic", groupId = "groupId", containerFactory = "factory")
    void deleteOrderListener(Order order) {
        int confirmationCode = getConfirmationCode();
        logger.info(order.getUser().getId() + " your confirmation code for deleting order is " + confirmationCode);
    }

    @KafkaListener(topics = "confirm-order-topic", groupId = "groupId", containerFactory = "factory")
    void confirmOrderListener(Order order) {
        int confirmationCode = getConfirmationCode();
        logger.info(order.getUser().getId() + " your confirmation code for confirming order is " + confirmationCode);
    }


    private int getConfirmationCode() {
        return new Random().nextInt(100_000, 999_999);
    }
}

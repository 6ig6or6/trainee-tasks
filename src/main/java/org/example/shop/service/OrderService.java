package org.example.shop.service;

import org.example.shop.repository.OrderRepository;
import org.example.shop.user.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order registerOrder(Order order) {
        logger.debug("Creating order with id {}", order.getId());
        return orderRepository.save(order);
    }
}

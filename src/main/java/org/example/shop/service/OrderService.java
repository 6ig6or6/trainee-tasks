package org.example.shop.service;

import org.example.shop.repository.OrderRepository;
import org.example.shop.user.Order;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order registerOrder(Order order) {
        return orderRepository.save(order);
    }
}

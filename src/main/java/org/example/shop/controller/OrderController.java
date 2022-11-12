package org.example.shop.controller;

import org.example.shop.dto.OrderDTO;
import org.example.shop.service.OrderService;
import org.example.shop.entity.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;
    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderController(OrderService orderService, KafkaTemplate<String, Order> kafkaTemplate) {
        this.orderService = orderService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity<Order> registerOrder(@Valid @RequestBody OrderDTO orderDTO) {
        Order order = orderService.registerOrder(orderDTO);
        kafkaTemplate.send("confirm-order-topic", order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrdersByUserId(@RequestParam String userId) {
        return new ResponseEntity<>(orderService.findOrdersByUserId(userId), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteOrder(Long id) {
        orderService.deleteOrder(id);
        kafkaTemplate.send("delete-order-topic", orderService.findById(id));
        return ResponseEntity.ok().build();
    }
}

package org.example.shop.service;

import org.example.shop.dto.OrderDTO;
import org.example.shop.exception.IncorrectIdException;
import org.example.shop.exception.OrderNotFoundException;
import org.example.shop.product.Product;
import org.example.shop.repository.OrderRepository;
import org.example.shop.entity.Order;
import org.example.shop.entity.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ProductService productService;

    public OrderService(OrderRepository orderRepository, UserService userService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.productService = productService;
    }

    @Transactional
    public Order registerOrder(Order order) {
        logger.debug("Creating order with sum {}", order.getSum());
        return orderRepository.save(order);
    }

    @Transactional
    public Order registerOrder(OrderDTO orderDTO) {
        Order order = createOrderFromDTO(orderDTO);
        logger.debug("Creating order from DTO with sum {}", order.getSum());
        return orderRepository.save(order);
    }

    @Transactional
    public void deleteOrder(Long id) {
        Order order = findById(id);
        orderRepository.delete(order);
        logger.debug("Order with id {} was deleted", id);
    }

    public Order findById(Long id) {
        if (id < 0) {
            throw new IncorrectIdException();
        }
        return orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    public List<Order> findOrdersByUserId(String uuid) {
        logger.debug("Finding all orders for user with id {}", uuid);
        return orderRepository.findAllByUserId(UUID.fromString(uuid));
    }

    private Order createOrderFromDTO(OrderDTO orderDTO) {
        User user = userService.getUser(orderDTO.getUserId());
        List<Product> products = productService.getAllProductsByIdList(orderDTO.getProductIds());
        double sum = products.stream().mapToDouble(Product::getPrice).sum();
        return Order.builder()
                .user(user)
                .products(products)
                .sum(sum)
                .build();
    }
}

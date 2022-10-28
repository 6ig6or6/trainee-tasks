package org.example.shop.operation.command;

import org.example.shop.service.OrderService;
import org.example.shop.service.UserService;
import org.example.shop.user.Bucket;
import org.example.shop.user.Order;
import org.example.shop.user.User;
import org.example.shop.util.ConsoleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfirmOrderCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(ConfirmOrderCommand.class);
    private final User currentUser;
    private final Bucket bucket;
    private final OrderService orderService;
    private final UserService userService;

    public ConfirmOrderCommand(User currentUser, Bucket bucket, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.bucket = bucket;
        this.orderService = orderService;
        this.userService = userService;
    }

    @Override
    public void execute() {
        Order order = createOrder();
        markOrderedProducts();
        Order registered = orderService.registerOrder(order);
        ConsoleHelper.printLine("Our order was registered " + registered.toString());
        logger.info("Order was confirmed " + order);
    }

    private Order createOrder() {
        Order order = new Order();
        order.setUser(currentUser);
        order.setSum(bucket.getTotalSum());
        order.setProducts(bucket.getProducts());
        return order;
    }

    private void markOrderedProducts() {
        bucket.getProducts().forEach(x -> x.setOrdered(true));
        userService.updateUser(currentUser);
    }
}

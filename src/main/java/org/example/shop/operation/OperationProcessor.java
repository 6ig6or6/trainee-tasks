package org.example.shop.operation;

import org.example.shop.operation.command.*;
import org.example.shop.service.OrderService;
import org.example.shop.service.ProductService;
import org.example.shop.user.Bucket;
import org.example.shop.service.UserService;
import org.example.shop.user.User;
import org.example.shop.util.ConsoleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OperationProcessor {
    private static final Logger logger = LoggerFactory.getLogger(OperationProcessor.class);
    private final UserService userService;
    private final OrderService orderService;
    private final ProductService productService;
    private User currentUser;
    public Bucket bucket;


    public OperationProcessor(UserService userService, OrderService orderService, ProductService productService) {
        this.userService = userService;
        this.orderService = orderService;
        this.productService = productService;
    }

    public void process() {
        String input;
        while (true) {
            verifyRegistration();
            printAllOperations();
            input = ConsoleHelper.readLine();
            if ("exit".equals(input) || "finish".equals(input)) {
                break;
            }
            try {
                chooseCommand(input);
            } catch (IllegalArgumentException e) {
                ConsoleHelper.printLine("Wrong operation number!");
                logger.warn("A user chose wrong operation type");
            }
        }
        userService.updateUser(currentUser);
    }

    public void chooseCommand(String operation) {
        Command currentOperation = switch (operation) {
            case "1" -> new ShowProductsListCommand(productService);
            case "2" -> new AddProductCommand(bucket, productService);
            case "3" -> new ShowBucketCommand(bucket);
            case "4" -> new DeleteProductFromBucketCommand(bucket);
            case "5" -> new ClearBucketCommand(bucket);
            case "6" -> new SeeCurrentBucketAmountCommand(bucket);
            case "7" -> new ConfirmOrderCommand(currentUser, bucket, orderService, userService);
            default -> throw new IllegalArgumentException("Unknown operation");
        };
        currentOperation.execute();
    }

    private void verifyRegistration() {
        if (currentUser == null) {
            currentUser = userService.checkForRegistration();
            bucket = currentUser.getBucket();
        }
    }

    private void printAllOperations() {
        ConsoleHelper.printLine("Choose needed operation or press exit:\n" +
                "1. Show product list.\n" +
                "2. Add chosen product to the bucket\n" +
                "3. Show products in the bucket\n" +
                "4. Delete(particular) product from the bucket\n" +
                "5. Clear the bucket\n" +
                "6. See current amount to pay\n" +
                "7. Confirm order\n" +
                "Enter number of the needed operation:\n");
    }
}
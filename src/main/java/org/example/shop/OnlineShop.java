package org.example.shop;

import org.example.shop.operation.OperationProcessor;
import org.example.shop.util.ConsoleHelper;
import org.springframework.stereotype.Component;

@Component
public class OnlineShop {
    private final OperationProcessor operationProcessor;

    public OnlineShop(OperationProcessor operationProcessor) {
        this.operationProcessor = operationProcessor;
    }

    public void start() {
        greetUser();
        startOperations();
        sayGoodbye();
    }

    private void startOperations() {
        operationProcessor.process();
    }

    private void greetUser() {
        ConsoleHelper.printLine("Welcome to our online shop!");
    }

    private void sayGoodbye() {
        ConsoleHelper.printLine("See you again!");
    }


}

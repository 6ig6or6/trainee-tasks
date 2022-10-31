package org.example.shop;

import org.example.shop.operation.OperationProcessor;
import org.example.shop.util.ConsoleHelper;

public class OnlineShop {
    private OperationProcessor operationProcessor;

    public OnlineShop() {
        this.operationProcessor = new OperationProcessor(new Bucket());
    }

    public static void main(String[] args) {
        OnlineShop onlineShop = new OnlineShop();
        onlineShop.start();
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

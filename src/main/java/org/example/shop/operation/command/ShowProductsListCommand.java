package org.example.shop.operation.command;

import org.example.shop.service.ProductService;
import org.example.shop.util.ConsoleHelper;


public class ShowProductsListCommand implements Command {
    private final ProductService productService;

    public ShowProductsListCommand(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        ConsoleHelper.printLine("All available products are:");
        productService.getAllProducts().stream().sorted((x, y) -> Math.toIntExact(x.getId() - y.getId()))
                .forEach(x -> ConsoleHelper.printLine("Id " + x.getId() + " " + x));
    }
}

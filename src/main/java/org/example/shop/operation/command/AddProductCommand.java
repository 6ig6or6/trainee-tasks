package org.example.shop.operation.command;

import org.example.shop.exception.ProductNotFoundException;
import org.example.shop.product.AbstractProduct;
import org.example.shop.service.ProductService;
import org.example.shop.user.Bucket;
import org.example.shop.util.ConsoleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AddProductCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(AddProductCommand.class);
    private final Bucket bucket;
    private final ProductService productService;

    public AddProductCommand(Bucket bucket, ProductService productService) {
        this.bucket = bucket;
        this.productService = productService;
    }

    @Override
    public void execute() {
        ConsoleHelper.printLine("Adding product to the bucket");
        ConsoleHelper.printLine("Please provide product id");
        AbstractProduct abstractProduct;
        long id;
        try {
            id = Long.parseLong(ConsoleHelper.readLine());
            abstractProduct = productService.getById(id);
        } catch (IllegalArgumentException e) {
            ConsoleHelper.printLine("Wrong number entered");
            logger.warn("Wrong symbol entered", e);
            return;
        } catch (ProductNotFoundException e) {
            ConsoleHelper.printLine("Wrong product id entered");
            logger.warn("Wrong product id entered", e);
            return;
        }
        bucket.addProduct(abstractProduct);
    }
}

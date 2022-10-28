package org.example.shop.service;

import org.example.shop.exception.ProductNotFoundException;
import org.example.shop.product.AbstractProduct;
import org.example.shop.product.Edible;
import org.example.shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public AbstractProduct registerProduct(AbstractProduct abstractProduct) {
        ensureStorageTime(abstractProduct);
        return productRepository.save(abstractProduct);
    }

    public void deleteProduct(AbstractProduct abstractProduct) {
        productRepository.delete(abstractProduct);
    }

    public List<AbstractProduct> getAllProducts() {
        return productRepository.findAll();
    }

    public AbstractProduct getById(Long id) {
        return productRepository
                .getAbstractProductById(id)
                .orElseThrow(ProductNotFoundException::new);
    }
    public void saveAll(List<AbstractProduct> products) {
        productRepository.saveAll(products);
    }

    private void ensureStorageTime(AbstractProduct product) {
        if (isEdible(product)) {
            setExpiryDate(product);
        }
    }

    private boolean isEdible(AbstractProduct product) {
        return product
                .getClass()
                .isAnnotationPresent(Edible.class);
    }

    private static void setExpiryDate(AbstractProduct product) {
        product.setExpirationDate(LocalDate.now()
                .plusDays(product.getNumberOfStorageDays()));
    }
}

package org.example.shop.service;

import org.example.shop.dto.ProductDTO;
import org.example.shop.exception.IncorrectIdException;
import org.example.shop.exception.ProductNotFoundException;
import org.example.shop.product.Product;
import org.example.shop.product.currency.Currency;
import org.example.shop.repository.ProductRepository;
import org.example.shop.util.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product registerProduct(ProductDTO productDTO) {
        Product product = Mapper.mapProductFromDTO(productDTO);
        setExpiryDate(product);
        logger.debug("Registering new product {}", product);
        return productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
        logger.debug("Product {} was deleted", product);
    }

    public List<Product> getAllProductsSortedById() {
        logger.debug("Getting all products from DB sorted by id");
        return productRepository.findByOrderById();
    }

    public List<Product> getAllProductsByIdList(List<Long> ids) {
        logger.debug("Getting all products from DB with ids {}", ids);
        return productRepository
                .findAll()
                .stream()
                .filter(x -> ids.contains(x.getId()))
                .toList();
    }

    public Product getById(Long id) {
        if (id < 0) {
            throw new IncorrectIdException();
        }
        return productRepository
                .getAbstractProductById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    public void saveAll(List<Product> products) {
        productRepository.saveAll(products);
        logger.debug("Saving {} products", products.size());
    }

    public void deleteById(Long id) {
        Product product = getById(id);
        deleteProduct(product);
        logger.debug("Product {} was deleted", product);
    }

    public Product updateById(Long id, ProductDTO productDTO) {
        Product product = getById(id);
        updateFields(product, productDTO);
        logger.debug("product with id {} was updated", product.getId());
        return productRepository.save(product);
    }

    private void updateFields(Product product, ProductDTO productDTO) {
        String name = productDTO.getName();
        Double price = productDTO.getPrice();
        Currency currency = productDTO.getPurchasingCurrency();
        Integer numberOfStorageDays = productDTO.getNumberOfStorageDays();
        Boolean isOrdered = productDTO.getIsOrdered();
        if (name != null) {
            product.setName(name);
        }
        if (price != null) {
            product.setPrice(price);
        }
        if (currency != null) {
            product.setPurchasingCurrency(currency);
        }
        if (numberOfStorageDays != null) {
            setExpiryDate(product);
        }
        if (isOrdered != null) {
            product.setOrdered(isOrdered);
        }
    }

    private void setExpiryDate(Product product) {
        product.setExpirationDate(LocalDate.now()
                .plusDays(product.getNumberOfStorageDays()));
    }
}

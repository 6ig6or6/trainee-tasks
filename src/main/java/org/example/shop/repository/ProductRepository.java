package org.example.shop.repository;

import org.example.shop.product.AbstractProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<AbstractProduct, Long> {
    Optional<AbstractProduct> getAbstractProductById(Long id);
}

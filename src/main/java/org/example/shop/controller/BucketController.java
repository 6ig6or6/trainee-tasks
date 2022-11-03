package org.example.shop.controller;

import org.example.shop.product.Product;
import org.example.shop.security.UserDetailsImpl;
import org.example.shop.service.ProductService;
import org.example.shop.service.UserService;
import org.example.shop.entity.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bucket")
public class BucketController {
    private final ProductService productService;
    private final UserService userService;

    public BucketController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> addProductsToBucket(@RequestBody List<Long> productIds,
                                                    @AuthenticationPrincipal UserDetailsImpl currentUser) {
        List<Product> products = productService.getAllProductsByIdList(productIds);
        User user = userService.getUser(currentUser.getUsername());
        user.getBucket().addAllProducts(products);
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProductsInBucket(@AuthenticationPrincipal UserDetailsImpl currentUser) {
        User user = userService.getUser(currentUser.getUsername());
        return new ResponseEntity<>(user.getBucket().getProducts(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductFromBucket(@PathVariable Long id,
                                                        @AuthenticationPrincipal UserDetailsImpl currentUser) {
        User user = userService.getUser(currentUser.getUsername());
        deleteProductsFromUserBucket(user, id);
        return ResponseEntity.ok().build();
    }

    private void deleteProductsFromUserBucket(User user, Long productId) {
        List<Product> products = user.getBucket().getProducts()
                .stream()
                .filter(x -> !x.getId().equals(productId))
                .toList();
        user.getBucket().clear();
        user.getBucket().addAllProducts(products);
    }
}

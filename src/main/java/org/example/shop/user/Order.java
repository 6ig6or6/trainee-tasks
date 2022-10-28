package org.example.shop.user;

import lombok.*;
import org.example.shop.product.AbstractProduct;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;
    private double sum;
    @Transient
    private List<AbstractProduct> products;
}

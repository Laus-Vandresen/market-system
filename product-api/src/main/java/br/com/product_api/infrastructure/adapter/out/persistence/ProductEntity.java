package br.com.product_api.infrastructure.adapter.out.persistence;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    private String name;

    private String description;

    private BigDecimal price;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    private boolean active;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
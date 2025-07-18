package br.com.product_api.domain.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


@Getter
public class Product {

    private final  UUID id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final int quantityInStock;
    private final boolean active;
    private final LocalDateTime createdAt;

    public Product(UUID id, String name, String description, BigDecimal price, int quantityInStock, boolean active) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        if (quantityInStock < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative");
        }

        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.active = active;
        this.createdAt = LocalDateTime.now();
    }

    public boolean isAvailable() {
        return active && quantityInStock > 0;
    }

    public Product disable() {
        return new Product(this.id, this.name, this.description, this.price, this.quantityInStock, false);
    }

    public Product addStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Stock addition must be positive");
        }
        return new Product(this.id, this.name, this.description, this.price, this.quantityInStock + quantity, this.active);
    }

    public Product removeStock(int quantity) {
        if (quantity <= 0 || quantity > this.quantityInStock) {
            throw new IllegalArgumentException("Invalid stock reduction");
        }
        return new Product(this.id, this.name, this.description, this.price, this.quantityInStock - quantity, this.active);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

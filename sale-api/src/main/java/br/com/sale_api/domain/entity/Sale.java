package br.com.sale_api.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Sale {
    private final List<SaleItem> items;
    private final BigDecimal totalPrice;
    private final LocalDateTime createdAt;

    public Sale(List<SaleItem> items) {
        this.items = items;
        this.totalPrice = calculateTotalPrice(items);
        this.createdAt = LocalDateTime.now();
    }

    private BigDecimal calculateTotalPrice(List<SaleItem> items) {
        return items.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
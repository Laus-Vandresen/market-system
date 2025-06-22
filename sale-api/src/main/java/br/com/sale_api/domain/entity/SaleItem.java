package br.com.sale_api.domain.entity;

import java.math.BigDecimal;
import java.util.UUID;

public class SaleItem {
    private final UUID productId;
    private final int quantity;
    private final BigDecimal price;

    public SaleItem(UUID productId, int quantity, BigDecimal price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public UUID getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
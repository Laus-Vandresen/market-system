package br.com.purchase_order_api.domain.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class PurchaseItem {

    private final UUID id;
    private final UUID productId;
    private final int quantity;
    private final BigDecimal price;

    public PurchaseItem(UUID id, UUID productId, int quantity, BigDecimal price) {
        this.id = id;
        if (quantity <= 0 || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Invalid item values.");
        }
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

}

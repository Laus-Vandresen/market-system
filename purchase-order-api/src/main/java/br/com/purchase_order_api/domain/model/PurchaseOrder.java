package br.com.purchase_order_api.domain.model;

import lombok.Getter;

import java.util.*;
import java.time.LocalDateTime;

@Getter
public class PurchaseOrder {
    private final UUID id;
    private final LocalDateTime createdAt;
    private final List<PurchaseItem> items;

    public PurchaseOrder(List<PurchaseItem> items) {
        if (items == null || items.isEmpty()) {
            throw new RuntimeException("Purchase must contain at least one item.");
        }
        this.id = null;
        this.createdAt = LocalDateTime.now();
        this.items = items;
    }

}

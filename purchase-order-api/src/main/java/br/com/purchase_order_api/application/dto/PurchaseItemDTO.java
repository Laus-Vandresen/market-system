package br.com.purchase_order_api.application.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class PurchaseItemDTO {
    private UUID id;
    private UUID productId;
    private int quantity;
    private BigDecimal price;

}

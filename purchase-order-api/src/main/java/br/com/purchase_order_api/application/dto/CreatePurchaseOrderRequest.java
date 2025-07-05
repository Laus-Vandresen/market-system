package br.com.purchase_order_api.application.dto;

import java.util.List;

public class CreatePurchaseOrderRequest {
    private List<PurchaseItemDTO> items;
    public List<PurchaseItemDTO> getItems() { return items; }
}

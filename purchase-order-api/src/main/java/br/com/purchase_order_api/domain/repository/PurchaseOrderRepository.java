package br.com.purchase_order_api.domain.repository;

import br.com.purchase_order_api.domain.model.PurchaseOrder;

import java.util.UUID;

public interface PurchaseOrderRepository {
    UUID save(PurchaseOrder purchaseOrder);
}

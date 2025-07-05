package br.com.purchase_order_api.infrastructure.repository;

import br.com.purchase_order_api.infrastructure.entity.PurchaseOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataPurchaseOrderRepository extends JpaRepository<PurchaseOrderEntity, UUID> {
}

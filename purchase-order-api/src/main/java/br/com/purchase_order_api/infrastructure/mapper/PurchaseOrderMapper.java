package br.com.purchase_order_api.infrastructure.mapper;

import br.com.purchase_order_api.domain.model.*;
import br.com.purchase_order_api.infrastructure.entity.*;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderMapper {

    public PurchaseOrderEntity toEntity(PurchaseOrder domain) {
        PurchaseOrderEntity entity = new PurchaseOrderEntity();
        entity.setId(domain.getId());
        entity.setCreatedAt(domain.getCreatedAt());

        for (PurchaseItem item : domain.getItems()) {
            PurchaseItemEntity itemEntity = new PurchaseItemEntity();
            itemEntity.setProductId(item.getProductId());
            itemEntity.setQuantity(item.getQuantity());
            itemEntity.setPrice(item.getPrice());
            entity.addItem(itemEntity);
        }

        return entity;
    }
}

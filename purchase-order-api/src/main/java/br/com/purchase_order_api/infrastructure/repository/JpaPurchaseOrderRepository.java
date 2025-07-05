package br.com.purchase_order_api.infrastructure.repository;

import br.com.purchase_order_api.domain.model.PurchaseOrder;
import br.com.purchase_order_api.domain.repository.PurchaseOrderRepository;
import br.com.purchase_order_api.infrastructure.entity.PurchaseOrderEntity;
import br.com.purchase_order_api.infrastructure.mapper.PurchaseOrderMapper;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class JpaPurchaseOrderRepository implements PurchaseOrderRepository {

    private final SpringDataPurchaseOrderRepository jpaRepo;
    private final PurchaseOrderMapper mapper;

    public JpaPurchaseOrderRepository(SpringDataPurchaseOrderRepository jpaRepo, PurchaseOrderMapper mapper) {
        this.jpaRepo = jpaRepo;
        this.mapper = mapper;
    }

    @Override
    public UUID save(PurchaseOrder purchaseOrder) {
        PurchaseOrderEntity entity = mapper.toEntity(purchaseOrder);
        PurchaseOrderEntity entityPersisted = jpaRepo.save(entity);
        return entityPersisted.getId();
    }
}
package br.com.purchase_order_api.application.service;

import br.com.purchase_order_api.domain.model.*;
import br.com.purchase_order_api.domain.repository.*;
import br.com.purchase_order_api.application.dto.*;
import java.util.*;
import java.util.stream.Collectors;

import br.com.purchase_order_api.infrastructure.feign.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreatePurchaseOrderService {

    private final PurchaseOrderRepository repository;
    private final ProductClient productClient;

    public UUID create(CreatePurchaseOrderRequest request) {
        List<PurchaseItem> items = request.getItems().stream()
            .map(dto -> new PurchaseItem(null, dto.getProductId(), dto.getQuantity(), dto.getPrice()))
            .collect(Collectors.toList());

        PurchaseOrder purchase = new PurchaseOrder(items);
        UUID purchaseId = repository.save(purchase);

        items.forEach(item -> productClient.increaseStock(item.getProductId(), item.getQuantity()));
        return purchaseId;
    }
}

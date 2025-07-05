package br.com.purchase_order_api.controller;

import br.com.purchase_order_api.application.dto.*;
import br.com.purchase_order_api.application.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    private final CreatePurchaseOrderService service;

    public PurchaseOrderController(CreatePurchaseOrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody CreatePurchaseOrderRequest request) {
        UUID id = service.create(request);
        return ResponseEntity.ok(Map.of("id", id));
    }
}

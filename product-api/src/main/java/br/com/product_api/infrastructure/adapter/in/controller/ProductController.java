package br.com.product_api.infrastructure.adapter.in.controller;

import br.com.product_api.application.port.in.DecreaseStockUseCase;
import br.com.product_api.application.port.in.FindProductUseCase;
import br.com.product_api.application.port.in.IncreaseStockUseCase;
import br.com.product_api.application.port.in.RegisterProductUseCase;
import br.com.product_api.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final RegisterProductUseCase registerProductUseCase;

    private final FindProductUseCase findProductUseCase;

    private final DecreaseStockUseCase decreaseStockUseCase;

    private final IncreaseStockUseCase increaseStockUseCase;

    @PostMapping
    public ResponseEntity<Product> register(@RequestBody Product product) {
        return ResponseEntity.ok(registerProductUseCase.register(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
        Product product = findProductUseCase.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/name")
    public ResponseEntity<Product> getProductByName(@RequestParam String name) {
        Product product = findProductUseCase.findByName(name);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/descrease-stock/{id}/{quantity}")
    public ResponseEntity<Product> decreaseStock(@PathVariable UUID id, @PathVariable int quantity) {
        return ResponseEntity.ok(decreaseStockUseCase.decreaseStock(id, quantity));
    }

    @PutMapping("/increase-stock/{id}/{quantity}")
    public ResponseEntity<Product> increaseStock(@PathVariable UUID id, @PathVariable int quantity) {
        return ResponseEntity.ok(increaseStockUseCase.increaseStock(id, quantity));
    }

}

package br.com.product_api.infrastructure.adapter.in.controller;

import br.com.product_api.application.port.in.FindProductUseCase;
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
}

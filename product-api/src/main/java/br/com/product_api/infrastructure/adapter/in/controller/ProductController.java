package br.com.product_api.infrastructure.adapter.in.controller;

import br.com.product_api.application.port.in.RegisterProductUseCase;
import br.com.product_api.domain.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final RegisterProductUseCase registerProductUseCase;

    public ProductController(RegisterProductUseCase registerProductUseCase) {
        this.registerProductUseCase = registerProductUseCase;
    }

    @PostMapping
    public ResponseEntity<Product> register(@RequestBody Product product) {
        return ResponseEntity.ok(registerProductUseCase.register(product));
    }
}

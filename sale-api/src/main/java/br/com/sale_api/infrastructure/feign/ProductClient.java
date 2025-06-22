package br.com.sale_api.infrastructure.feign;

import br.com.sale_api.infrastructure.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;

@FeignClient(name = "product-api")
public interface ProductClient {

    @GetMapping("/products/{id}")
    ProductResponse getProductById(@PathVariable UUID id);

    @PutMapping("/api/products/descrease-stock/{id}/{quantity}")
    ProductResponse decreaseStock(@PathVariable UUID id, @PathVariable int quantity);
}

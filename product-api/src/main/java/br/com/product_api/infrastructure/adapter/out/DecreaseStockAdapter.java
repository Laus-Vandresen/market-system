package br.com.product_api.infrastructure.adapter.out;

import br.com.product_api.application.port.out.DecreaseStockPort;
import br.com.product_api.domain.model.Product;
import br.com.product_api.infrastructure.adapter.out.persistence.ProductEntity;
import br.com.product_api.infrastructure.adapter.out.persistence.ProductJpaRepository;
import br.com.product_api.infrastructure.adapter.out.persistence.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class DecreaseStockAdapter implements DecreaseStockPort {

    private final ProductJpaRepository repository;

    public DecreaseStockAdapter(ProductJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product decreaseStock(UUID id, int quantity) {
        Optional<ProductEntity> productEntity = repository.findById(id);
        if (productEntity.isPresent()) {
            productEntity.get().setQuantityInStock(productEntity.get().getQuantityInStock() - quantity);
            return ProductMapper.toDomain(repository.save(productEntity.get()));
        }
        return null;
    }
}

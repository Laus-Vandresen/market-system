package br.com.product_api.infrastructure.adapter.out;

import br.com.product_api.application.port.out.FindProductPort;
import br.com.product_api.domain.model.Product;
import br.com.product_api.infrastructure.adapter.out.persistence.ProductJpaRepository;
import br.com.product_api.infrastructure.adapter.out.persistence.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class FindProductAdapter implements FindProductPort {

    private final ProductJpaRepository repository;

    public FindProductAdapter(ProductJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product findByName(String name) {
        var productEntity = repository.findByName(name);
        return ProductMapper.toDomain(productEntity);
    }

    @Override
    public Optional<Product> findById(UUID id) {
        var productEntity = repository.findById(id);
        return productEntity.map(ProductMapper::toDomain);
    }
}

package br.com.product_api.infrastructure.adapter.out;

import br.com.product_api.application.port.out.SaveProductPort;
import br.com.product_api.domain.model.Product;
import br.com.product_api.infrastructure.adapter.out.persistence.ProductEntity;
import br.com.product_api.infrastructure.adapter.out.persistence.ProductJpaRepository;
import br.com.product_api.infrastructure.adapter.out.persistence.ProductMapper;
import org.springframework.stereotype.Component;

@Component
public class SaveProductAdapter implements SaveProductPort {

    private final ProductJpaRepository repository;

    public SaveProductAdapter(ProductJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = ProductMapper.toEntity(product);
        ProductEntity saved = repository.save(entity);
        return ProductMapper.toDomain(saved);
    }
}
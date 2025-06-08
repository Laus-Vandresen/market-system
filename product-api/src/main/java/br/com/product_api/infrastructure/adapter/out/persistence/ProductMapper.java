package br.com.product_api.infrastructure.adapter.out.persistence;

import br.com.product_api.domain.model.Product;

public class ProductMapper {

    public static ProductEntity toEntity(Product domain) {
        ProductEntity entity = new ProductEntity();
        entity.setName(domain.getName());
        entity.setDescription(domain.getDescription());
        entity.setPrice(domain.getPrice());
        entity.setQuantityInStock(domain.getQuantityInStock());
        entity.setActive(domain.isActive());
        entity.setCreatedAt(domain.getCreatedAt());
        return entity;
    }

    public static Product toDomain(ProductEntity entity) {
        return new Product(
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getQuantityInStock(),
                entity.isActive()
        );
    }

}

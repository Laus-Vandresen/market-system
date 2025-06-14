package br.com.product_api.application.port.out;

import br.com.product_api.domain.model.Product;

import java.util.UUID;

public interface FindProductPort {

    Product findByName(String name);

    Product findById(UUID id);
}

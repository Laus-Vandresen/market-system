package br.com.product_api.application.port.in;

import br.com.product_api.domain.model.Product;

public interface RegisterProductUseCase {
    Product register(Product product);
}

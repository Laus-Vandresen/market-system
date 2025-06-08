package br.com.product_api.application.port.out;

import br.com.product_api.domain.model.Product;

public interface SaveProductPort {
    Product save(Product product);
}

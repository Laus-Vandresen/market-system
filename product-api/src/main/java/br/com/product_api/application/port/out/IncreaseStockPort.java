package br.com.product_api.application.port.out;

import br.com.product_api.domain.model.Product;

import java.util.UUID;

public interface IncreaseStockPort {

    Product increaseStock(UUID id, int quantity);
}

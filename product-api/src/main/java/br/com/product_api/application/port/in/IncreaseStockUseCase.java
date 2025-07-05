package br.com.product_api.application.port.in;

import br.com.product_api.domain.model.Product;

import java.util.UUID;

public interface IncreaseStockUseCase {

    Product increaseStock(UUID id, int quantity);
}

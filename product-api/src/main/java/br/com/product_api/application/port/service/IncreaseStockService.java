package br.com.product_api.application.port.service;

import br.com.product_api.application.port.exception.InsufficientStockException;
import br.com.product_api.application.port.in.DecreaseStockUseCase;
import br.com.product_api.application.port.in.IncreaseStockUseCase;
import br.com.product_api.application.port.out.DecreaseStockPort;
import br.com.product_api.application.port.out.FindProductPort;
import br.com.product_api.application.port.out.IncreaseStockPort;
import br.com.product_api.domain.model.Product;

import java.util.UUID;

public class IncreaseStockService implements IncreaseStockUseCase {

    private final IncreaseStockPort increaseStockPort;

    public IncreaseStockService(IncreaseStockPort increaseStockPort) {
        this.increaseStockPort = increaseStockPort;
    }

    @Override
    public Product increaseStock(UUID id, int quantity) {
        return increaseStockPort.increaseStock(id, quantity);
    }
}

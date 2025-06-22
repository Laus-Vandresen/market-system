package br.com.product_api.application.port.service;

import br.com.product_api.application.port.exception.InsufficientStockException;
import br.com.product_api.application.port.in.DecreaseStockUseCase;
import br.com.product_api.application.port.out.DecreaseStockPort;
import br.com.product_api.application.port.out.FindProductPort;
import br.com.product_api.domain.model.Product;

import java.util.UUID;

public class DecreaseStockService implements DecreaseStockUseCase {

    private final DecreaseStockPort decreaseStockPort;
    private final FindProductPort findProductPort;

    public DecreaseStockService(DecreaseStockPort decreaseStockPort, FindProductPort findProductPort) {
        this.decreaseStockPort = decreaseStockPort;
        this.findProductPort = findProductPort;
    }

    @Override
    public Product decreaseStock(UUID id, int quantity) {
        Product product = findProductPort.findById(id);
        if (product.getQuantityInStock() < quantity) {
            throw new InsufficientStockException(String.format("Insufficient stock for product with ID: %s", id));
        }
        return decreaseStockPort.decreaseStock(id, quantity);
    }
}

package br.com.product_api.application.port.service;

import br.com.product_api.application.port.in.RegisterProductUseCase;
import br.com.product_api.application.port.out.SaveProductPort;
import br.com.product_api.domain.model.Product;

import java.util.UUID;

public class RegisterProductService implements RegisterProductUseCase {

    private final SaveProductPort saveProductPort;

    public RegisterProductService(SaveProductPort saveProductPort) {
        this.saveProductPort = saveProductPort;
    }

    @Override
    public Product register(Product product) {
        return saveProductPort.save(product);
    }
}

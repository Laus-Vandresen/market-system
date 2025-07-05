package br.com.product_api.application.port.service;

import br.com.product_api.application.port.in.FindProductUseCase;
import br.com.product_api.application.port.out.FindProductPort;
import br.com.product_api.domain.model.Product;

import java.util.UUID;

public class FindProductService implements FindProductUseCase {

    private final FindProductPort findProductPort;

    public FindProductService(FindProductPort findProductPort) {
        this.findProductPort = findProductPort;
    }

    @Override
    public Product findByName(String name) {
        return findProductPort.findByName(name);
    }

    @Override
    public Product findById(UUID id) {
        return findProductPort.findById(id).orElse(null);
    }
}

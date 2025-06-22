package br.com.sale_api.application.usecase;

import br.com.sale_api.domain.entity.Sale;
import br.com.sale_api.domain.entity.SaleItem;
import br.com.sale_api.domain.repository.SaleRepository;
import br.com.sale_api.infrastructure.dto.SaleRequest;
import br.com.sale_api.infrastructure.feign.ProductClient;
import br.com.sale_api.infrastructure.mapper.SaleMapper;

public class RegisterSaleUseCase {

    private final SaleRepository saleRepository;
    private final ProductClient productClient;

    public RegisterSaleUseCase(SaleRepository saleRepository, ProductClient productClient) {
        this.saleRepository = saleRepository;
        this.productClient = productClient;
    }

    public void register(SaleRequest saleRequest) {
        Sale sale = SaleMapper.requestToDomain(saleRequest);
        for (SaleItem item : sale.getItems()) {
            try {
                productClient.decreaseStock(item.getProductId(), item.getQuantity());
            } catch (Exception e) {
                throw new RuntimeException("Failed to register sale due to stock issue", e);
            }
        }
        saleRepository.save(sale);
    }
}
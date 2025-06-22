package br.com.sale_api.infrastructure.config;

import br.com.sale_api.application.usecase.RegisterSaleUseCase;
import br.com.sale_api.domain.repository.SaleRepository;
import br.com.sale_api.infrastructure.feign.ProductClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public RegisterSaleUseCase registerSaleUseCase(SaleRepository saleRepository, ProductClient productClient) {
        return new RegisterSaleUseCase(saleRepository, productClient);
    }
}
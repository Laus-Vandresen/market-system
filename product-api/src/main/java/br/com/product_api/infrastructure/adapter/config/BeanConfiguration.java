package br.com.product_api.infrastructure.adapter.config;

import br.com.product_api.application.port.in.FindProductUseCase;
import br.com.product_api.application.port.in.RegisterProductUseCase;
import br.com.product_api.application.port.out.FindProductPort;
import br.com.product_api.application.port.out.SaveProductPort;
import br.com.product_api.application.port.service.FindProductService;
import br.com.product_api.application.port.service.RegisterProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public RegisterProductUseCase registerProductUseCase(SaveProductPort saveProductPort) {
        return new RegisterProductService(saveProductPort);
    }

    @Bean
    public FindProductUseCase findProductUseCase(FindProductPort findProductPort) {
        return new FindProductService(findProductPort);
    }
}

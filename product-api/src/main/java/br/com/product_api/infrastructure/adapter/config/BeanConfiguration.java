package br.com.product_api.infrastructure.adapter.config;

import br.com.product_api.application.port.in.DecreaseStockUseCase;
import br.com.product_api.application.port.in.FindProductUseCase;
import br.com.product_api.application.port.in.IncreaseStockUseCase;
import br.com.product_api.application.port.in.RegisterProductUseCase;
import br.com.product_api.application.port.out.DecreaseStockPort;
import br.com.product_api.application.port.out.FindProductPort;
import br.com.product_api.application.port.out.IncreaseStockPort;
import br.com.product_api.application.port.out.SaveProductPort;
import br.com.product_api.application.port.service.DecreaseStockService;
import br.com.product_api.application.port.service.FindProductService;
import br.com.product_api.application.port.service.IncreaseStockService;
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

    @Bean
    public DecreaseStockUseCase decreaseStockUseCase(DecreaseStockPort decreaseStockPort, FindProductPort findProductPort) {
        return new DecreaseStockService(decreaseStockPort, findProductPort);
    }

    @Bean
    public IncreaseStockUseCase increaseStockUseCase(IncreaseStockPort increaseStockPort) {
        return new IncreaseStockService(increaseStockPort);
    }
}

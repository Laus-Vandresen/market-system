package br.com.sale_api.infrastructure.controller;

import br.com.sale_api.application.usecase.RegisterSaleUseCase;
import br.com.sale_api.infrastructure.dto.SaleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final RegisterSaleUseCase registerSaleUseCase;

    public SaleController(RegisterSaleUseCase registerSaleUseCase) {
        this.registerSaleUseCase = registerSaleUseCase;
    }

    @PostMapping
    public void registerSale(@RequestBody SaleRequest saleRequest) {
        registerSaleUseCase.register(saleRequest);
    }
}

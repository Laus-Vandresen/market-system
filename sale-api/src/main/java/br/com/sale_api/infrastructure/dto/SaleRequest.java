package br.com.sale_api.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class SaleRequest {
    private List<SaleItemRequest> items;

    public List<SaleItemRequest> getItems() {
        return items;
    }
}
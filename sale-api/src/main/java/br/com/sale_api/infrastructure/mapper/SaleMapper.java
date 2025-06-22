package br.com.sale_api.infrastructure.mapper;

import br.com.sale_api.domain.entity.Sale;
import br.com.sale_api.domain.entity.SaleItem;
import br.com.sale_api.infrastructure.dto.SaleRequest;
import br.com.sale_api.infrastructure.entity.SaleEntity;
import br.com.sale_api.infrastructure.entity.SaleItemEntity;

import java.util.List;

public class SaleMapper {

    public static Sale requestToDomain(SaleRequest request) {
        List<SaleItem> items = request.getItems().stream()
                .map(i -> new SaleItem(i.getProductId(), i.getQuantity(), i.getPrice()))
                .toList();

        return new Sale(items);
    }

    public static SaleEntity domainToEntity(Sale sale) {
        return new SaleEntity(domainItemSaleToEntity(sale.getItems()), sale.getTotalPrice(), sale.getCreatedAt());
    }

    private static List<SaleItemEntity> domainItemSaleToEntity(List<SaleItem> items) {
        return items.stream()
                .map(item -> new SaleItemEntity(item.getProductId(), item.getQuantity()))
                .toList();
    }


}

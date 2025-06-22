package br.com.sale_api.domain.repository;

import br.com.sale_api.domain.entity.Sale;

public interface SaleRepository {
    void save(Sale sale);

}
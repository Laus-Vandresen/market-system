package br.com.sale_api.infrastructure.repository;

import br.com.sale_api.domain.entity.Sale;
import br.com.sale_api.domain.repository.SaleRepository;
import br.com.sale_api.infrastructure.entity.SaleEntity;
import br.com.sale_api.infrastructure.mapper.SaleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public class SaleRepositoryImpl implements SaleRepository {

    private final JpaSaleRepository jpaSaleRepository;

    public SaleRepositoryImpl(JpaSaleRepository jpaSaleRepository) {
        this.jpaSaleRepository = jpaSaleRepository;
    }

    @Override
    public void save(Sale sale) {
        SaleEntity entity = SaleMapper.domainToEntity(sale);
        jpaSaleRepository.save(entity);
    }
}
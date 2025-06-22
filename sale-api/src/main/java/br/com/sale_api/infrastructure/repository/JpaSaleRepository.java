package br.com.sale_api.infrastructure.repository;

import br.com.sale_api.infrastructure.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface JpaSaleRepository extends JpaRepository<SaleEntity, UUID> {
}
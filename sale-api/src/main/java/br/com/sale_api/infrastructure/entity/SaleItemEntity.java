package br.com.sale_api.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
@Table(name = "sale_items")
public class SaleItemEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    private UUID productId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private SaleEntity sale;

    public SaleItemEntity(UUID productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

}
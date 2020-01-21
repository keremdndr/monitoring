package com.bundle.monitoring.model.dto;

import com.bundle.monitoring.model.request.Sale;
import lombok.Setter;

import java.util.UUID;

@Setter
public class SaleDTO {
    private Long id;
    private UUID code;

    public SaleDTO toDTO(Sale sale){
        id = sale.getId();
        code = sale.getSaleCode();
        return this;
    }
}

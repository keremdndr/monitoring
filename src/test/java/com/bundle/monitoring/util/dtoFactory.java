package com.bundle.monitoring.util;

import com.bundle.monitoring.model.dto.MonitoringDTO;
import com.bundle.monitoring.model.dto.ProductDTO;
import com.bundle.monitoring.model.dto.SaleDTO;

import java.math.BigDecimal;
import java.util.UUID;

public final class dtoFactory {

    public static MonitoringDTO monitoringDTO(){
        MonitoringDTO monitoringDTO = new MonitoringDTO();
        monitoringDTO.setStatus("Teslim Edildi");
        monitoringDTO.setProduct(productDTO());
        monitoringDTO.setSale(saleDTO());

        return monitoringDTO;
    }

    public static ProductDTO productDTO(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("MacBook Pro");
        productDTO.setPrice(new BigDecimal(6000.50));

        return productDTO;
    }

    public static SaleDTO saleDTO(){
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setCode(UUID.fromString("56613a46-d0eb-47ec-9303-aca508d8aa66"));
        saleDTO.setId(1L);

        return saleDTO;
    }
}

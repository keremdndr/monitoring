package com.bundle.monitoring.model.dto;

import com.bundle.monitoring.model.request.Product;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
public class ProductDTO {
    private Long id;
    private BigDecimal price;
    private String name;

    public ProductDTO toDTO(Product product){
        id = product.getId();
        price = product.getPrice();
        name = product.getName();

        return this;
    }
}

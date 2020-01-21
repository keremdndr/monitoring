package com.bundle.monitoring.model.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.net.URL;

@Getter
@Setter
public class Product {
    private Long id;
    private String category;
    private String name;
    private BigDecimal price;
    private URL image;
}

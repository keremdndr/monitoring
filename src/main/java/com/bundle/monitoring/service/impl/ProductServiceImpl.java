package com.bundle.monitoring.service.impl;

import com.bundle.monitoring.model.request.Product;
import com.bundle.monitoring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCT_API = "http://5e209e06e31c6e0014c60962.mockapi.io/api/products/";

    private RestTemplate restTemplate;

    @Autowired
    public ProductServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public Product getById(Long id) {
        Product product = restTemplate.getForObject(PRODUCT_API + id, Product.class);
        return product;
    }
}

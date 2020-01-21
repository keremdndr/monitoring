package com.bundle.monitoring.service.impl;

import com.bundle.monitoring.model.request.Sale;
import com.bundle.monitoring.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SaleServiceImpl implements SaleService {

    private static final String SALE_API = "http://5e209e06e31c6e0014c60962.mockapi.io/api/sales/";

    private RestTemplate restTemplate;

    @Autowired
    public SaleServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public Sale getById(Long id) {
        Sale sale = restTemplate.getForObject(SALE_API + id, Sale.class);
        return sale;
    }
}

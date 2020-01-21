package com.bundle.monitoring.service.impl;

import com.bundle.monitoring.model.request.Shipping;
import com.bundle.monitoring.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShippingServiceImpl implements ShippingService {

    private static final String SHIPPING_API = "http://5e209e06e31c6e0014c60962.mockapi.io/api/shipping/";

    private RestTemplate restTemplate;

    @Autowired
    public ShippingServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public Shipping getById(Long id) {
        Shipping shipping = restTemplate.getForObject( SHIPPING_API + id, Shipping.class);
        return shipping;
    }
}

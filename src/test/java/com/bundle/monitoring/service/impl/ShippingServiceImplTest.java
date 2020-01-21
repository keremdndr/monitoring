package com.bundle.monitoring.service.impl;

import com.bundle.monitoring.model.request.Shipping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;

class ShippingServiceImplTest {

    @InjectMocks
    private ShippingServiceImpl sut;

    @BeforeEach
    void setUp() {
        sut = new ShippingServiceImpl(new RestTemplateBuilder());
    }

    @Test
    void whenShippingIdGivenThenReturnShipping() throws MalformedURLException {
        Shipping byId = sut.getById(1L);
        assertThat(byId).isNotNull();
    }

}
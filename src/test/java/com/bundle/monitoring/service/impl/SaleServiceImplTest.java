package com.bundle.monitoring.service.impl;

import com.bundle.monitoring.model.request.Sale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;

class SaleServiceImplTest {

    @InjectMocks
    private SaleServiceImpl sut;

    @BeforeEach
    void setUp() {
        sut = new SaleServiceImpl(new RestTemplateBuilder());
    }

    @Test
    void whenSaleIdGivenThenReturnSale() throws MalformedURLException {
        Sale byId = sut.getById(1L);
        assertThat(byId).isNotNull();
    }
}
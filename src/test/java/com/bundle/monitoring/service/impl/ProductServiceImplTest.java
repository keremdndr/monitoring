package com.bundle.monitoring.service.impl;

import com.bundle.monitoring.model.request.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.web.client.RestTemplateBuilder;
import java.net.MalformedURLException;
import static org.assertj.core.api.Assertions.assertThat;

class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl sut;

    @BeforeEach
    void setUp() {
        sut = new ProductServiceImpl(new RestTemplateBuilder());
    }

    @Test
    void whenProductIdGivenThenReturnProduct() throws MalformedURLException {
        Product byId = sut.getById(1L);
        assertThat(byId).isNotNull();
    }
}
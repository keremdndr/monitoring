package com.bundle.monitoring.service.impl;

import com.bundle.monitoring.service.ProductService;
import com.bundle.monitoring.service.SaleService;
import com.bundle.monitoring.service.ShippingService;
import com.bundle.monitoring.util.requestFactory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;


class MonitoringServiceImplTest {

    @Mock
    private ProductService productService;

    @Mock
    private SaleService saleService;

    @Mock
    private ShippingService shippingService;

    @InjectMocks
    private MonitoringServiceImpl sut;

    @Test
    void whenSaleIdGivenThenReturnResponseDTO() throws MalformedURLException {
        MockitoAnnotations.initMocks(this);

        Mockito.when(saleService.getById(Mockito.anyLong())).thenReturn(requestFactory.sale());
        Mockito.when(productService.getById(Mockito.anyLong())).thenReturn(requestFactory.product());
        Mockito.when(shippingService.getById(Mockito.anyLong())).thenReturn(requestFactory.shipping());

        String saleAndShipping = sut.getSaleAndShipping(1L);
        assertThat(saleAndShipping).isNotNull();
        assertThat(saleAndShipping).contains("TESLIM EDILDI");
    }
}